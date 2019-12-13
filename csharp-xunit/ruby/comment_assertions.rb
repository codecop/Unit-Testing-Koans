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

  elsif line =~ /(\S.*) = Assert.Throws<([^>]+)>\((.*)\);/
    "#{$`}// TODO Check #{$2} thrown from #{$3}.#{$'}"
  elsif line =~ /Assert.Throws<([^>]+)>\((.*)\);/
    "#{$`}// TODO Check #{$1} thrown from #{$2}.#{$'}"

  elsif line =~ /Assert\.(\w+)\((.*)\);/
    # comment general assertions
    comment_assert($`, $1, $2, $')

  elsif line =~ /(\S.*)\.Should\(\).(\w+)\((.*)\);/
    # comment fluent assertions
    comment_assert($`, $2, $1 + ', ' + $3, $')

  elsif line =~ /\[InlineData\((.*)\)\]/
    # comment test data
    "#{$`}// * #{$1}#{$'}"

  elsif line =~ /(\[Theory\]|\[ClassData\(.*\)\])(\s*\/\/)?/
    # comment test factory
    "#{$`}// TODO#{$'}"

  elsif line =~ /\(Skip = "(.*)"\)\]/
    # comment disabled
    "#{$`}] // TODO Mark this test as ignored with \"#{$1}\".#{$'}"

  else
    # regular line
    line

  end
end

def comment_assert(before, term, args, after)
  front = "#{before}// TODO Check that "
  how = ''
  back = ".#{after}"

  if term == 'That'
    # Hamcrest
    what = args.gsub(/Is\./, ''). # too verbose
                gsub(/\)\.|\((?!\))/, ' '). # remove ). and (
                gsub(/\)+$/, '') # remove trailing )s

  elsif term == 'Equal' || term == 'NotEqual' ||
        term == 'Equals' || term == 'NotEquals'
    a = args.sub(/, 3/, ''). # remove double rounding
             sub(/, /, ' and ')
    what = "#{a} are "
    how = term.downcase().
      sub(/not/, 'not ').
      sub(/equals/, 'equal')

  elsif term == 'InRange' ||
        term == 'Contains' || term == 'NotContains'
    how = term.downcase().
      sub(/not/, 'not ').
      sub(/inrange/, 'in range').
      sub(/contains/, 'contained in')
    what = args.sub(/, /, " is #{how} ")
    how = ''

  elsif term == 'Contain' || term == 'NotContain' ||
        term == 'HaveCount'
    how = term.downcase().
      sub(/not/, 'not ').
      sub(/havecount/, 'have count of')
    what = args.sub(/, /, " does #{how} ")
    how = ''

  else
    what = "#{args} is "
    how = term.downcase().
      sub(/not/, 'not ')
  end

  front + what + how + back
end

def save(file_name, lines)
  File.open(file_name, "w") do |file|
    lines.each { |line| file.print line }
  end
end

if __FILE__ == $0

  Dir.chdir('WordCount.Tests')

  # comment session files
  Dir['Session*.cs'].each do |file_name|
    modify(file_name)
  end

  Dir.chdir('..')

end
