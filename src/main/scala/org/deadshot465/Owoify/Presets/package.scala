package org.deadshot465.Owoify

import org.deadshot465.Owoify.Structures.Word

package object Presets {
  val SPECIFIC_WORD_MAPPING_LIST: Array[Word => Word] = Array(
    Mappings.mapFucToFwuc, Mappings.mapMomToMwom, Mappings.mapTimeToTim, Mappings.mapMeToMwe,
    Mappings.mapNVowelToNy, Mappings.mapOverToOwor, Mappings.mapOveToUv, Mappings.mapHahaToHeheXd,
    Mappings.mapTheToTeh, Mappings.mapYouToU, Mappings.mapReadToWead, Mappings.mapWorseToWose
  )

  val UVU_MAPPING_LIST: Array[Word => Word] = Array(
    Mappings.mapOToOwO, Mappings.mapEwToUwu, Mappings.mapHeyToHay, Mappings.mapDeadToDed,
    Mappings.mapNVowelTToNd
  )

  val UWU_MAPPING_LIST: Array[Word => Word] = Array(
    Mappings.mapBracketToStarTrails, Mappings.mapPeriodCommaExclamationSemicolonToKaomojis,
    Mappings.mapThatToDat, Mappings.mapThToF, Mappings.mapLeToWal, Mappings.mapVeToWe,
    Mappings.mapRyToWwy, Mappings.mapROrLToW
  )

  val OWO_MAPPING_LIST: Array[Word => Word] = Array(
    Mappings.mapLlToWw, Mappings.mapVowelOrRExceptOLToWl, Mappings.mapOldToOwld, Mappings.mapOlToOwl,
    Mappings.mapLOrROToWo, Mappings.mapSpecificConsonantsOToLetterAndWo, Mappings.mapVOrWLeToWal,
    Mappings.mapFiToFwi, Mappings.mapVerToWer, Mappings.mapPoiToPwoi, Mappings.mapSpecificConsonantsLeToLetterAndWal,
    Mappings.mapConsonantsRToConsonantW, Mappings.mapLyToWy, Mappings.mapPleToPwe, Mappings.mapNrToNw
  )
}
