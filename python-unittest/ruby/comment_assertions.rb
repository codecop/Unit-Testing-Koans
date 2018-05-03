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
  if line =~ /\s*# keep/
    # leave that line alone, just remove the marker
    "#{$`}#{$'}"

  elsif line =~ /# use\s/
    # remove comment to use code that was commented
    "#{$`}#{$'}"

  elsif line =~ /\s*# drop\s*$/
    # drop line
    "#{$'}"

  elsif line =~ /self\.assertRaises\(([^,]+), (.*)\)/
    "#{$`}# TODO Expect #{$1} is thrown from #{$2}.#{$'}"

  elsif line =~ /self\.assertRaisesRegexp\(([^,]+), ("[^"]+"), (.*)\)/
    "#{$`}# TODO Expect #{$1} with message #{$2} is thrown from #{$3}.#{$'}"

  elsif line =~ /(?:self\.)?assert(\w+)\((.*)\)/
    # comment general assertions
    comment_assert($`, $1, $2, $')

  elsif line =~ /@parameterized\.expand\(([^)]+)\)/
    # parameterized
    "#{$`}# TODO Mark this test as parameterized with #{$1}.#{$'}"

  elsif line =~ /@unittest\.skip\(([^)]+)\)/
    # comment disabled
    "#{$`}# TODO Mark this test as ignored with #{$1}.#{$'}"

  else
    # regular line
    line

  end
end

def comment_assert(before, term, args, after)
  front = "#{before.sub(/\(\) -> /, '')}# TODO Check that "
  how = ''
  back = ".#{after}"

  if term == "_that"
    # Hamcrest and assertpy
    what = args.gsub(/\)\.|\((?!\))/, ' '). # remove ). and (
      gsub(/\)+$/, '') # remove trailing )s

  elsif term == "True"
    what = args

  elsif term == "AlmostEqual"
    what = args.sub(/, delta=0\.01/, ' is equal') # remove double rounding

  else
    what = "#{args} is "
    how = term.downcase().
      sub(/not|isnot/, "not ").
      sub(/isnone|none/, "None").
      sub(/in/, "included").
      sub(/regexpmatches/, "matched by regular expression")
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
  Dir['test_session*.py'].each do |file_name|
    modify(file_name)
  end

  Dir.chdir('..')

end
