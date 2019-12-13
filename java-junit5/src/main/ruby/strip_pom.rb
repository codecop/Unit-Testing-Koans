#! ruby

def load(file_name)
  IO.readlines(file_name)
end

def strip_extra_lines(lines)
  blacklist =  %w| <!-- <name> <description> <inceptionYear> <url> <scm> <connection> <developerConnection> </scm> <project. |
  lines.find_all do |line|
    blacklist.find { |stop_word| starts_with?(line, stop_word) } == nil
  end
end

def starts_with?(line, word)
  line =~ /^\s*#{Regexp.escape(word)}/
end

def remove_extra_dependencies(lines)
  start_tag = '</dependency>'
  end_tag = '</dependencies>'
  active = true
  tag_seen = false

  lines.find_all do |line|
    if starts_with?(line, end_tag)
      tag_seen = false
      active = false
      true # take this

    elsif tag_seen
      false # skip all

    elsif active and starts_with?(line, start_tag)
      tag_seen = true
      true # take this

    else
      true

    end
  end
end

def remove_empty_lines(lines)
  lines.
    zip(lines.drop(1)). # pairs of line with next line
    find_all { |pair| pair[0] != pair[1] }.
    map { |pair| pair[0] }
end

def save(file_name, lines)
  File.open(file_name, "w") do |file|
    lines.each { |line| file.print line }
  end
end

if __FILE__ == $0

  puts 'stripping pom'
  pom = load('pom.xml')
  pom = strip_extra_lines(pom)
  pom = remove_extra_dependencies(pom)
  pom = remove_empty_lines(pom)
  save('stripped-pom.xml', pom)

end
