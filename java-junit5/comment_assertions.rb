Dir.chdir('src/test/java')

Dir['**/Session*Test.java'].each do |file_name|
  # report
  puts "modifying #{file_name}"

  # load
  lines = IO.readlines(file_name)

  # modify
  lines = lines.map do |line|
    if line =~ /\/\/ keep\s*$/
      # leave that line alone, just remove marker
      line.sub(/\/\/ keep\s*$/, '')

    elsif line =~ /(\S.*) = assertThrows\((.*)\);/
      "#{$`}// TODO Expect #{$1} is thrown from #{$2}.#{$'}"

    elsif line =~ /assert(\w+)\((.*)\);/
      # comment general assertions
      front = "#{$`}// TODO Check that "
      how = ''
      back = ".#{$'}"

      if $1 == "Equals" or $1 == "That" or $1 == "True" or $1 == "ArrayEquals"
        what = $2.gsub(/, 0\.01/, '') # ignore double rounding
      else
        what = "#{$2} is "
        how = $1.downcase().
          sub(/not/, "not "). # needs to be last to preserve $0
          sub(/throws/, "thrown")
      end

      front + what + how + back

    elsif line =~ /@TestFactory|@BeforeEach|@AfterEach/
      # comment test factory
      # comment life cycle
      "#{$`}// TODO #{$'}"

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
File.delete('org/codecop/StringToFileTest.java')

Dir.chdir('../../..')
