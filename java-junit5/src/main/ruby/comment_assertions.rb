#! ruby

def modify(file_name)
  puts "modifying #{file_name}"
  lines = load(file_name)
  lines = lines.map { |line| comment_assertion_in(line) }
  save(file_name, lines)
end

def load(file_name)
  IO.readlines(file_name)
end

def comment_assertion_in(line)
  if line =~ /\/\/ keep/
    # leave that line alone, just remove the marker
    "#{$`}#{$'}"

  elsif line =~ /\/\/ use\s/
    # remove comment to use code that was commented
    "#{$`}#{$'}"

  elsif line =~ /\/\/ drop\s*$/
    # drop line
    "#{$'}"

  elsif line =~ /(\S.*) = assertThrows\((.*)\);/
    "#{$`}// TODO Expect #{$1} is thrown from #{$2}.#{$'}"

  elsif line =~ /assert(\w+)\((.*)\)(?:;|,)?/
    # comment general assertions
    comment_assert($`, $1, $2, $') 
    
  elsif line =~ /(@TestFactory|@BeforeEach|@AfterEach|@ExtendWith\([^)]+\)|@ParameterizedTest|@MethodSource\([^)]+\))(\s*\/\/)?/
    # comment test factory, life cycle, extension
    "#{$`}// TODO#{$'}"

  elsif line =~ /@Disabled\((.*)\)/
    # comment disabled
    "#{$`}// TODO Mark this test as ignored with #{$1}.#{$'}"

  else
    # regular line
    line
    
  end
end

def comment_assert(before, term, args, after)
  front = "#{before.sub(/\(\) -> /, '')}// TODO Check that "
  how = ''
  back = ".#{after}"

  if term == "That" 
    # Hamcrest and AssertJ
    what = args.gsub(/\)\.|\((?!\))/, ' '). # remove ). and ( 
                gsub(/\)+$/, '') # remove trailing )s

  elsif term == "ArrayEquals" or term == "True"
    what = args
  
  elsif term == "Equals"
    what = args.sub(/, 0\.01/, ''). # remove double rounding
              sub(/Integer.valueOf\(2\)/, '2') # remove boxing

  elsif term == "Timeout"
    what = "#{args} has a "
    how = term.downcase()
  
  else
    what = "#{args} is "
    how = term.downcase().
      sub(/not/, "not "). 
      sub(/iterable/, "iterable "). 
      sub(/equals/, "equal"). 
      sub(/throws/, "thrown")
  end

  front + what + how + back
end

def save(file_name, lines)
  File.open(file_name, "w") do |file|
    lines.each { |line| file.print line }
  end
end

def delete(file_name)
  puts "deleting #{file_name}"
  File.delete(file_name)
end

if __FILE__ == $0

  Dir.chdir('src/test/java')
  
  # comment session files
  Dir['**/Session*.java'].each do |file_name|
    modify(file_name)
  end
  
  # remove useless files
  ['org/codecop/StringToFileTest.java'].each do |file_name|
    delete(file_name)
  end
  
  Dir.chdir('../../..')

end
