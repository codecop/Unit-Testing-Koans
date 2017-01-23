Dir.chdir('src/test/java')

Dir['**/Session*.java'].each do |file_name|
  # report
  puts "modifying #{file_name}"

  # load
  lines = IO.readlines(file_name)

  # modify
  lines = lines.map do |line|
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

    elsif line =~ /assert(\w+)\((.*)\);/
      # comment general assertions
      front = "#{$`}// TODO Check that "
      how = ''
      back = ".#{$'}"

      if $1 == "ArrayEquals" or $1 == "That" or $1 == "True"
        what = $2
      elsif $1 == "Equals"
        what = $2.sub(/, 0\.01/, ''). # remove double rounding
                  sub(/Integer.valueOf\(2\)/, '2') # remove boxing
      elsif $1 == "Timeout"
        what = "#{$2} has a "
        how = $1.downcase()
      else
        what = "#{$2} is "
        how = $1.downcase().
          sub(/not/, "not "). # needs to be last to preserve $0
          sub(/iterable/, "iterable "). 
          sub(/equals/, "equal"). 
          sub(/throws/, "thrown")
      end

      front + what + how + back

    elsif line =~ /@TestFactory|@BeforeEach|@AfterEach|@ExtendWith\([^)]+\)/
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

  # save
  File.open(file_name, "w") { |file|
    lines.each { |line| file.print line }
  }
end

# remove useless test
['org/codecop/StringToFileTest.java'].each do |file_name|
  puts "deleting #{file_name}"
  File.delete(file_name)
end

Dir.chdir('../../..')
