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

  elsif line =~ /\$this->setExpectedException\(([^,]+),(.+)\);/
    "#{$`}// TODO Expect #{$1} is thrown with message #{$2}.#{$'}"

  elsif line =~ /(?:\$this->)?assert(\w+)\((.*)\)(?:;|,)?/
    # comment general assertions
    comment_assert($`, $1, $2, $')

  elsif line =~ /(\/\*\* @before \*\/|\/\*\* @after \*\/)(\s*\/\/)?/
    # comment life cycle
    "#{$`}// TODO#{$'}"

  elsif line =~ /$this->markTestIncomplete\((.*)\);/
    # comment disabled
    "#{$`}// TODO Mark this test as incomplete with #{$1}.#{$'}"

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
    what = args.sub(/, 0\.01/, '') # remove double rounding

  else
    what = "#{args} is "
    how = term.downcase().
      sub(/not/, "not ").
      sub(/equals/, "equal")
  end

  front + what + how + back
end

def save(file_name, lines)
  File.open(file_name, "w") do |file|
    lines.each { |line| file.print line }
  end
end

if __FILE__ == $0

  Dir.chdir('test')

  # comment session files
  Dir['Session*.php'].each do |file_name|
    modify(file_name)
  end

  Dir.chdir('..')

end
