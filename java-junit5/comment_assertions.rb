Dir.chdir('src/test/java')

Dir['**/Session*Test.java'].each do |file_name|
  # load
  lines = IO.readlines(file_name)

  # modify
  lines = lines.map do |line|
    if line =~ /\/\/ keep/
      # leave keep alone
      line

    elsif line =~ /assert(\w+)\((.*)\);/
      # comment assertions
      if $1 == "Equals" or $1 == "That" or $1 == "True" or $1 == "ArrayEquals"
        "#{$`}// TODO check that #{$2}#{$'}"
      else
        front = "#{$`}// TODO check that #{$2} is "
        back = $'
        what = $1.downcase().
            sub(/not/, "not "). # needs to be last
            sub(/throws/, "thrown")
        front + what + back
      end

    elsif line =~ /@Disabled\((.*)\)/
      # comment disabled
      "#{$`}// TODO mark test as ignored with #{$1}#{$'}"

    elsif line =~ /@BeforeEach/
      # comment life cycle
      "#{$`}// TODO this needs to be called before each test#{$'}"
    elsif line =~ /@AfterEach/
      "#{$`}// TODO this needs to be called after each test#{$'}"

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

Dir.chdir('../../..')
