package org.deadshot465

import org.deadshot465.Owoify.OwoifyLevel.OwoifyLevel
import org.deadshot465.Owoify.Structures.Word

package object Owoify {
  object OwoifyLevel extends Enumeration {
    type OwoifyLevel = Value
    val Owo, Uwu, Uvu = Value
  }

  private val WORD_REGEX = raw"[^\s]+".r
  private val SPACE_REGEX = raw"\s+".r

  def owoify(source: String, level: OwoifyLevel = OwoifyLevel.Owo): String = {
    val wordMatches = WORD_REGEX.findAllMatchIn(source)
    val spaceMatches = SPACE_REGEX.findAllMatchIn(source)
    var words = wordMatches.map(w => new Word(w.group(0)))
    var spaces = spaceMatches.map(w => new Word(w.group(0)))

    words = words.map(w => {
      var _word = w
      for (f <- Presets.SPECIFIC_WORD_MAPPING_LIST) {
        _word = f(_word)
      }
      level match {
        case OwoifyLevel.Owo =>
          for (f <- Presets.OWO_MAPPING_LIST) {
            _word = f(_word)
          }
        case OwoifyLevel.Uwu =>
          for (f <- Presets.UWU_MAPPING_LIST) {
            _word = f(_word)
          }
          for (f <- Presets.OWO_MAPPING_LIST) {
            _word = f(_word)
          }
        case OwoifyLevel.Uvu =>
          for (f <- Presets.UVU_MAPPING_LIST) {
            _word = f(_word)
          }
          for (f <- Presets.UWU_MAPPING_LIST) {
            _word = f(_word)
          }
          for (f <- Presets.OWO_MAPPING_LIST) {
            _word = f(_word)
          }
      }
      _word
    })

    val result = Util.interleaveArrays(words, spaces)
    val resultStrings = result.map(w => w.toString)
    resultStrings.mkString("")
  }
}
