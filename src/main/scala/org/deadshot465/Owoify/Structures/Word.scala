package org.deadshot465.Owoify.Structures

import scala.collection.mutable
import scala.util.matching.Regex

class Word(private var word: String) {
  private var replacedWords = mutable.HashSet[String]()

  def replace(searchValue: Regex, replaceValue: String, replaceReplacedWords: Boolean = false): Word = {
    if (!replaceReplacedWords && searchValueContainsReplacedWords(searchValue, replaceValue)) {
      return this
    }
    var replacingWord = word
    if (searchValue.findFirstMatchIn(word).isDefined) {
      replacingWord = searchValue.replaceAllIn(word, replaceValue)
    }
    val collection = searchValue.findAllMatchIn(word)
    var replacedWords = List[String]()
    if (collection.length > 1) {
      replacedWords = collection.map(_match => _match.group(0).replace(_match.group(0), replaceValue))
        .toList
    }
    if (replacingWord != word) {
      for (
        _word <- replacedWords
      ) {
        this.replacedWords += _word
      }
      word = replacingWord
    }
    this
  }

  def replace(searchValue: Regex, func: () => String, replaceReplacedWords: Boolean): Word = {
    val replaceValue = func()
    if (!replaceReplacedWords && searchValueContainsReplacedWords(searchValue, replaceValue)) {
      return this
    }
    var replacingWord = word
    if (searchValue.findFirstMatchIn(word).isDefined) {
      val matchItem = searchValue.findFirstMatchIn(word).get.group(0)
      replacingWord = word.replace(matchItem, replaceValue)
    }
    val collection = searchValue.findAllMatchIn(word)
    var replacedWords = List[String]()
    if (collection.length > 1) {
      replacedWords = collection.map(_match => _match.group(0).replace(_match.group(0), replaceValue))
        .toList
    }
    if (replacingWord != word) {
      for (
        _word <- replacedWords
      ) {
        this.replacedWords += _word
      }
      word = replacingWord
    }
    this
  }

  def replace(searchValue: Regex, func: (String, String) => String, replaceReplacedWords: Boolean): Word = {
    if (searchValue.findFirstMatchIn(this.word).isEmpty) {
      return this
    }
    val word = this.word
    val captures = searchValue.findFirstMatchIn(word)
    val replaceValue = func(captures.get.group(1), captures.get.group(2))
    if (!replaceReplacedWords && searchValueContainsReplacedWords(searchValue, replaceValue)) {
      return this
    }
    val replacingWord = this.word.replace(captures.get.group(0), replaceValue)
    val collection = searchValue.findAllMatchIn(this.word)
    var replacedWords = List[String]()
    if (collection.length > 1) {
      replacedWords = collection.map(_match => _match.group(0).replace(_match.group(0), replaceValue))
        .toList
    }
    if (replacingWord != this.word) {
      for (
        _word <- replacedWords
      ) {
        this.replacedWords += _word
      }
      this.word = replacingWord
    }
    this
  }

  override def toString: String = this.word

  private def searchValueContainsReplacedWords(searchValue: Regex, replaceValue: String): Boolean = {
    this.replacedWords.exists(s => {
      val matchItem = searchValue.findFirstMatchIn(s)
      if (matchItem.isDefined) {
        var matchResult = matchItem.get.group(0)
        return s.replace(matchResult, replaceValue) == s
      }
      return false
    })
  }
}