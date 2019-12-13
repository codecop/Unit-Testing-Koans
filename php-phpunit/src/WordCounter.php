<?php
namespace Wordcount;

class FileNotFoundException extends \Exception {}

/**
 * Counts words of a text and provides basic analysis of that.
 */
class WordCounter {

    private $words;

    static function fromFile($fileName) {
        if (!file_exists($fileName)) {
            throw new FileNotFoundException($fileName);
        }
        $contents = file_get_contents($fileName);
        return new WordCounter($contents);
    }

    function __construct($sentence) {
        $this->words =  preg_split("/\s+/", $sentence);
    }

    function numberOfWords() {
        sleep(0.1); // here some hard core calculation...
        return count($this->words);
    }

    /**
     * @return unique words sorted alphabetically.
     */
    function uniqueWords() {
        $uniqueWords = array_unique($this->words);
        sort($uniqueWords);
        return $uniqueWords;
    }

    function containsWord($word) {
        return in_array($word, $this->words);
    }

    function countOf($word) {
        $sum = 0;
        foreach ($this->words as $s) {
            if ($word == $s) {
                $sum++;
            }
        }

        if ($sum > 0) {
            return $sum;
        }
        return null;
    }

    /**
     * @return ratio of this word's occurrence against all words.
     */
    function ratioOf($word) {
        $count = $this->countOf($word);
        if (!$count) {
            throw new \InvalidArgumentException($word . " not in sentence");
        }
        return 1.0 * $count / $this->numberOfWords();
    }

    function firstUniqueWord() {
        return $this->uniqueWords()[0];
    }

}
