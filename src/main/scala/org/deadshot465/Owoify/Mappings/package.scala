package org.deadshot465.Owoify

import org.deadshot465.Owoify.Structures.Word
import scala.util.Random

package object Mappings {
  private val O_TO_OWO = raw"o".r
  private val EW_TO_UWU = raw"ew".r
  private val HEY_TO_HAY = raw"([Hh])ey".r
  private val DEAD_TO_DED_UPPER = raw"Dead".r
  private val DEAD_TO_DED_LOWER = raw"dead".r
  private val N_VOWEL_T_TO_ND = raw"n[aeiou]*t".r
  private val READ_TO_WEAD_UPPER = raw"Read".r
  private val READ_TO_WEAD_LOWER = raw"read".r
  private val BRACKETS_TO_STARTRAILS_FORE = raw"[({<]".r
  private val BRACKETS_TO_STARTRAILS_REAR = raw"[)}>]".r
  private val PERIOD_COMMA_EXCLAMATION_SEMICOLON_TO_KAOMOJIS_FIRST = raw"[.,](?![0-9])".r
  private val PERIOD_COMMA_EXCLAMATION_SEMICOLON_TO_KAOMOJIS_SECOND = raw"[!;]+".r
  private val THAT_TO_DAT_UPPER = raw"That".r
  private val THAT_TO_DAT_LOWER = raw"that".r
  private val TH_TO_F_UPPER = raw"TH(?!E)".r
  private val TH_TO_F_LOWER = raw"[Tt]h(?![Ee])".r
  private val LE_TO_WAL = raw"le$$".r
  private val VE_TO_WE_UPPER = raw"Ve".r
  private val VE_TO_WE_LOWER = raw"ve".r
  private val RY_TO_WWY = raw"ry".r
  private val RORL_TO_W_UPPER = raw"(?:R|L)".r
  private val RORL_TO_W_LOWER = raw"(?:r|l)".r
  private val LL_TO_WW = raw"ll".r
  private val VOWEL_OR_R_EXCEPT_O_L_TO_WL_UPPER = raw"[AEIUR]([lL])$$".r
  private val VOWEL_OR_R_EXCEPT_O_L_TO_WL_LOWER = raw"[aeiur]l$$".r
  private val OLD_TO_OWLD_UPPER = raw"OLD".r
  private val OLD_TO_OWLD_LOWER = raw"([Oo])ld".r
  private val OL_TO_OWL_UPPER = raw"OL".r
  private val OL_TO_OWL_LOWER = raw"([Oo])l".r
  private val LORR_O_TO_WO_UPPER = raw"[LR]([oO])".r
  private val LORR_O_TO_WO_LOWER = raw"[lr]o".r
  private val SPECIFIC_CONSONANTS_O_TO_LETTER_AND_WO_UPPER = raw"([BCDFGHJKMNPQSTXYZ])([oO])".r
  private val SPECIFIC_CONSONANTS_O_TO_LETTER_AND_WO_LOWER = raw"([bcdfghjkmnpqstxyz])o".r
  private val VORW_LE_TO_WAL = raw"[vw]le".r
  private val FI_TO_FWI_UPPER = raw"FI".r
  private val FI_TO_FWI_LOWER = raw"([Ff])i".r
  private val VER_TO_WER = raw"([Vv])er".r
  private val POI_TO_PWOI = raw"([Pp])oi".r
  private val SPECIFIC_CONSONANTS_LE_TO_LETTER_AND_WAL = raw"([DdFfGgHhJjPpQqRrSsTtXxYyZz])le$$".r
  private val CONSONANT_R_TO_CONSONANT_W = raw"([BbCcDdFfGgKkPpQqSsTtWwXxZz])r".r
  private val LY_TO_WY_UPPER = raw"Ly".r
  private val LY_TO_WY_LOWER = raw"ly".r
  private val PLE_TO_PWE = raw"([Pp])le".r
  private val NR_TO_NW_UPPER = raw"NR".r
  private val NR_TO_NW_LOWER = raw"nr".r
  private val FUC_TO_FWUC = raw"([Ff])uc".r
  private val MOM_TO_MWOM = raw"([Mm])om".r
  private val ME_TO_MWE = raw"([Mm])e".r
  private val N_VOWEL_TO_NY_FIRST = raw"n([aeiou])".r
  private val N_VOWEL_TO_NY_SECOND = raw"N([aeiou])".r
  private val N_VOWEL_TO_NY_THIRD = raw"N([AEIOU])".r
  private val OVE_TO_UV_UPPER = raw"OVE".r
  private val OVE_TO_UV_LOWER = raw"ove".r
  private val HAHA_TO_HEHE_XD = raw"\b(ha|hah|heh|hehe)+\b".r
  private val THE_TO_TEH = raw"\b([Tt])he\b".r
  private val YOU_TO_U_UPPER = raw"\bYou\b".r
  private val YOU_TO_U_LOWER = raw"\byou\b".r
  private val TIME_TO_TIM = raw"\b([Tt])ime\b".r
  private val OVER_TO_OWOR = raw"([Oo])ver".r
  private val WORSE_TO_WOSE = raw"([Ww])orse".r

  private val FACES = Array("(・`ω´・)", ";;w;;", "owo", "UwU", ">w<", "^w^", "(* ^ ω ^)", "(⌒ω⌒)", "ヽ(*・ω・)ﾉ", "(o´∀`o)", "(o･ω･o)", "＼(＾▽＾)／", "(*^ω^)", "(◕‿◕✿)", "(◕ᴥ◕)", "ʕ•ᴥ•ʔ", "ʕ￫ᴥ￩ʔ", "(*^.^*)", "(｡♥‿♥｡)", "OwO", "uwu", "uvu", "UvU", "(*￣з￣)", "(つ✧ω✧)つ", "(/ =ω=)/", "(╯°□°）╯︵ ┻━┻", "┬─┬ ノ( ゜-゜ノ)", "¯\\_(ツ)_/¯")

  def mapOToOwO(input: Word): Word = {
    val replacement = if (Random.nextInt(2) > 0) {
      "owo"
    } else {
      "o"
    }
    input.replace(O_TO_OWO, replacement)
  }

  def mapEwToUwu(input: Word): Word = {
    input.replace(EW_TO_UWU, "uwu")
  }

  def mapHeyToHay(input: Word): Word = {
    input.replace(HEY_TO_HAY, "$1ay")
  }

  def mapDeadToDed(input: Word): Word = {
    input
      .replace(DEAD_TO_DED_UPPER, "Ded")
      .replace(DEAD_TO_DED_LOWER, "ded")
  }

  def mapNVowelTToNd(input: Word): Word = {
    input.replace(N_VOWEL_T_TO_ND, "nd")
  }

  def mapReadToWead(input: Word): Word = {
    input
      .replace(READ_TO_WEAD_UPPER, "Wead")
      .replace(READ_TO_WEAD_LOWER, "wead")
  }

  def mapBracketToStarTrails(input: Word): Word = {
    input
      .replace(BRACKETS_TO_STARTRAILS_FORE, "｡･:*:･ﾟ★,｡･:*:･ﾟ☆")
      .replace(BRACKETS_TO_STARTRAILS_REAR, "☆ﾟ･:*:･｡,★ﾟ･:*:･｡")
  }

  def mapPeriodCommaExclamationSemicolonToKaomojis(input: Word): Word = {
    input.replace(PERIOD_COMMA_EXCLAMATION_SEMICOLON_TO_KAOMOJIS_FIRST, () => {
      FACES(Random.nextInt(FACES.length))
    }, replaceReplacedWords = false)
      .replace(PERIOD_COMMA_EXCLAMATION_SEMICOLON_TO_KAOMOJIS_SECOND, () => {
        FACES(Random.nextInt(FACES.length))
      }, replaceReplacedWords = false)
  }

  def mapThatToDat(input: Word): Word = {
    input
      .replace(THAT_TO_DAT_LOWER, "dat")
      .replace(THAT_TO_DAT_UPPER, "Dat")
  }

  def mapThToF(input: Word): Word = {
    input.replace(TH_TO_F_LOWER, "f")
      .replace(TH_TO_F_UPPER, "F")
  }

  def mapLeToWal(input: Word): Word = {
    input.replace(LE_TO_WAL, "wal")
  }

  def mapVeToWe(input: Word): Word = {
    input.replace(VE_TO_WE_LOWER, "we")
      .replace(VE_TO_WE_UPPER, "We")
  }

  def mapRyToWwy(input: Word): Word = {
    input.replace(RY_TO_WWY, "wwy")
  }

  def mapROrLToW(input: Word): Word = {
    input.replace(RORL_TO_W_LOWER, "w")
      .replace(RORL_TO_W_UPPER, "W")
  }


  def mapLlToWw(input: Word): Word = {
    input.replace(LL_TO_WW, "ww")
  }

  def mapVowelOrRExceptOLToWl(input: Word): Word = {
    input.replace(VOWEL_OR_R_EXCEPT_O_L_TO_WL_LOWER, "wl")
      .replace(VOWEL_OR_R_EXCEPT_O_L_TO_WL_UPPER, "W$1")
  }

  def mapOldToOwld(input: Word): Word = {
    input.replace(OLD_TO_OWLD_LOWER, "$1wld")
      .replace(OLD_TO_OWLD_UPPER, "OWLD")
  }

  def mapOlToOwl(input: Word): Word = {
    input.replace(OL_TO_OWL_LOWER, "$1wl")
      .replace(OL_TO_OWL_UPPER, "OWL")
  }

  def mapLOrROToWo(input: Word): Word = {
    input.replace(LORR_O_TO_WO_LOWER, "wo")
      .replace(LORR_O_TO_WO_UPPER, "W$1")
  }

  def mapSpecificConsonantsOToLetterAndWo(input: Word): Word = {
    input.replace(SPECIFIC_CONSONANTS_O_TO_LETTER_AND_WO_LOWER, "$1wo")
      .replace(SPECIFIC_CONSONANTS_O_TO_LETTER_AND_WO_UPPER, (str1: String, str2: String) => {
        var msg = str1
        msg = msg.concat(if (str2.toUpperCase() == str2) {
          "W"
        } else {
          "w"
        })
        msg = msg.concat(str2)
        msg
      }, replaceReplacedWords = false)
  }


  def mapVOrWLeToWal(input: Word): Word = {
    input.replace(VORW_LE_TO_WAL, "wal")
  }

  def mapFiToFwi(input: Word): Word = {
    input.replace(FI_TO_FWI_LOWER, "$1wi")
      .replace(FI_TO_FWI_UPPER, "FWI")
  }

  def mapVerToWer(input: Word): Word = {
    input.replace(VER_TO_WER, "wer")
  }

  def mapPoiToPwoi(input: Word): Word = {
    input.replace(POI_TO_PWOI, "$1woi")
  }

  def mapSpecificConsonantsLeToLetterAndWal(input: Word): Word = {
    input.replace(SPECIFIC_CONSONANTS_LE_TO_LETTER_AND_WAL, "$1wal")
  }

  def mapConsonantsRToConsonantW(input: Word): Word = {
    input.replace(CONSONANT_R_TO_CONSONANT_W, "$1w")
  }

  def mapLyToWy(input: Word): Word = {
    input.replace(LY_TO_WY_LOWER, "wy")
      .replace(LY_TO_WY_UPPER, "Wy")
  }

  def mapPleToPwe(input: Word): Word = {
    input.replace(PLE_TO_PWE, "$1we")
  }

  def mapNrToNw(input: Word): Word = {
    input.replace(NR_TO_NW_LOWER, "nw")
      .replace(NR_TO_NW_UPPER, "NW")
  }

  def mapFucToFwuc(input: Word): Word = {
    input.replace(FUC_TO_FWUC, "$1wuc")
  }

  def mapMomToMwom(input: Word): Word = {
    input.replace(MOM_TO_MWOM, "$1wom")
  }

  def mapMeToMwe(input: Word): Word = {
    input.replace(ME_TO_MWE, "$1we")
  }

  def mapNVowelToNy(input: Word): Word = {
    input.replace(N_VOWEL_TO_NY_FIRST, "ny$1")
      .replace(N_VOWEL_TO_NY_SECOND, "Ny$1")
      .replace(N_VOWEL_TO_NY_THIRD, "NY$1")
  }

  def mapOveToUv(input: Word): Word = {
    input.replace(OVE_TO_UV_LOWER, "uv")
      .replace(OVE_TO_UV_UPPER, "UV")
  }

  def mapHahaToHeheXd(input: Word): Word = {
    input.replace(HAHA_TO_HEHE_XD, "hehe xD")
  }

  def mapTheToTeh(input: Word): Word = {
    input.replace(THE_TO_TEH, "$1eh")
  }

  def mapYouToU(input: Word): Word = {
    input.replace(YOU_TO_U_UPPER, "U")
      .replace(YOU_TO_U_LOWER, "u")
  }

  def mapTimeToTim(input: Word): Word = {
    input.replace(TIME_TO_TIM, "$1im")
  }

  def mapOverToOwor(input: Word): Word = {
    input.replace(OVER_TO_OWOR, "$1wor")
  }

  def mapWorseToWose(input: Word): Word = {
    input.replace(WORSE_TO_WOSE, "$1ose")
  }
}