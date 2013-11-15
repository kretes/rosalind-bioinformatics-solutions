
package proteins

import org.scalatest.{Matchers, FlatSpec}
import org.assertj.core.api.Assertions
import scala.collection.JavaConverters._

class DNAChainSubstringEncodesProteinSpec extends FlatSpec with Matchers {

  "DNA" should "contain subgenomes that encodes protein - example" in {
    val genome: String = "ATGGCCATGGCCCCCAGAACTGAGATCAATAGTACCCGTATTAACGGGTGA"
    val protein:String = "MA";

    val substrings: Iterator[String] = getAllSubstringsEncodingProtein(genome, protein)

    Assertions.assertThat(substrings.asJava).containsOnly(
      "ATGGCC",
      "GGCCAT",
      "ATGGCC")
  }

  "DNA" should "contain subgenomes that encodes protein - extra example" in {
    val genome: String = "TTCGAATCCGTATTGCTTTGGTTGGTTGAGAGAGCGACCTACATTGCTAGTCAGAATAGGTGATTCACACAAAGCTTAGCACCTGGGCAGCACCCCGTGATGTAAACCTATGGGAACTAAGGGAGTCCTGCGGTTTTAGCCAGCAAGCGAGCCGGCAGGAACACTCATACCATCGGACGCGTTTGACGCCTCCCCGGAAAGGAAGTATTTGAGCCTCATTATTACGTATTGCCCGTTAGTCGACAAATCAAGCCCTCGTACGCAGCTTATTCGTACGACGTGGAGGCGTTCCCACGGGCCTAACACGATTGGAACACCACCATAGTAGTGTGGTTCAAATACCTCCTTTGGAGATCTAGAGCTTCACTCTGATTCTAGAGGCAACTTTACAATCGCTCTACGAAATTGTATGGACATCATCAACCGGATATTCTGGGGCGGTAGAATTTCTTTTGTTCGAATCGCTCTAGGCCAGGATCAAATTAATTGAATTGCGGACTCAAGGATCGCGATAGCCGACACATCGGACGCTGTAGAAAGCCAGTCTCTGGATTTAATCCACCCTCTATGTTTGACAAAGCACTAAAACGGGATAGTTTCGGGTGGTATAAGTTTCCCAAGACGATTGCATCGCAATTCATCAACAACCATGAACTTACTGTTTTAGTACTTCCACACACCTTGTTAAATTACGCCTTTACTTCATGTTGCGGTGTGTGTTAGATAGTGTGCAGCTACAAGTCTACCGCCATCGCAGCTCGGGATACCGGCAGATGAGATGGTCCTGAGCTCGTACCGGACTCAAACTTTTTCCTTTACTACCTAGGAATCGCCCATGCGAATTTGTCGGACACACACCATTACATTAACGTCACAACAGCTACTGTTAGAATTTTGCTCTTGCAAATCCTGGAAAGAGTTAAAAAAACTCTTCCGCGCGCCAATAGGGTAAATAATAGATAGCCAGACGGCTGTAAGAGGTGATGACATTTGCAACAATCATGCTGTCGCATCTTCCGCAAGTTCATGTCGCGCCTAGGCAATGGATCTGCGAATGGGGGCCACGGGGTATGAACTACGGAATTCTAAGAAAGTTGCCATCCAGAGTTAAGGGTTTGAGGCTAGTTGCATCGCTGGTAACGAACTACCTCATTACTTGGACGCGCAGTGTGACTTCACTCCTGTATAGCGATGATGCCAAGCAGGAATTAGCAAATCTGAAGAGCGTTTCCAAACTGGCCACTTGGACTGACACCTATCGCGGGGGATTTCAGCGCGTGTCGCTCTCACATGAGAGCTGCCGTCAGGAGCGGTAGAGTTTAGAGAGGAATGCGACAAACTCCCTATTCACCTCTCTGGTGATGTAAGGATATTTACGCTTAGTTCTATGCCAGGCTTAGGGCCTCTCGGAACTTTGGTGAGTCCTTATTAATTGATGCTACCTCTCCCTTACCTTCGCCCCAAGTCACGTAGAAGTACTCAATCCTGCTACATGATAATCAAATATTTCCAACGTTGGGAAATCGGTGACATCACATACTAGTTAAGAAACCACTGTCAGTGAACTTATATCCGGGGGAGAAAATCTACTAACTTACATACGCTGTGCGAGCAGTTTTCATTATAAGAAAATATACTCCCGAGGTACCGCATCAAGCACGACATTCCCGGAGAGCATAACATTTCGGTGCACCTGCTTTTGTGCGCTTGCTTGCGGTTATTTATAAACTACGCACAAGGCGCAAACCGCAGTGCGCATGTTTTCTCCGCCTGGCTAGAACTCGACATTCTCGTCAACGCCAATCTATGTGAGAGGATTTAGACCTCTGTGAAAACGAGTCCCTCTATAGAATAAATACCCAGATGCCAATGGGGGTTCTATCCGATGGCAGTGCATGGAGTGGTGGCTCCAGATTAAGGATGAGGAGAGGTAAAGATAACAGTTCGGTCGCCACGACGCGTTGCCAATCGAAATATCAGTACTAAAAGGCCCACCGCTCCGCTTTAGTCCGACTTTACATCCTGTGGAAATTGTCGAACGGAGGCTACATCGGGCTATATGAGTGTGAAAACCTATACTTCTCGCGTCGTTACTCAGTGCCGGTCTCCTGTTTCCCCCAGTCTTACGTACCCTTATTGATATTTGCTTCACGTTGAAACGTCCTAACGCAGCGTAAAGAGGTGTTTGAACCTCATTACTATAAAATCGCGATCGAAGGTAGACTACATACGCAAACGCCGAAACCCTCAGTTGGCCTTGTTGCAAGTATGGAACGTTGTAAAATTTTTCCTAGACGTTGAGCTATCGGTACAAGGTCGTTAGCGTCCTTACCCTTCACTTATATGCCCGACAAAACGCGGGTCCTAGTGCAGTGGTGGGAGCTTGGAATCCCGCAATACAAGGACAACCTGTATCTCGTTCGGCGTTCCGCGATCACTCGATCCCGAACCACTCCAAGCCTGGTTGATCAGCAAAAGCGGAAGGATGGATAAAGGGCTACTGGTTAATGGATGTAAACTTCCAATGATGAAATCCTGGAAACGAGGGATCGGGTTACGGTGGCGAACGGGGTACGGCAACGTGGCTATCTAGAGCCCGACGTTACGACTCATGTACATGCTGCTACGTGGTTGAAGCTGACGTTCAGATGAAGCAGTACTGAGTCCTAGGGCTTACTACTACTCCAATAGGTCTGGCCGGCCAGATACAAAAGTTCGTGGCGGCTCACCCCCTTTCTGGCGGGTGTAGCTTGCTGACCGGTTTGCTCGATAACACAGGCTAGCGAATAGTAATGAGGTTCGAAAACCTCTTTCCAACGACTGAAAGGGTCTACACGAACTATCTACATTTCCCCGCCCATGTCCTTCCGTCTGGTTGCTTCTGGAGATCCTTTCGCATTATACCGCAGCGTAGTGGCTCTGGCATATATGAAAAAATCCTTCTGTGGGTATTTGTGCCATCACTTATTGTTCGTACCGATATGGGATTACAAGTGCGATGTGATAATAAGCGAAGAAGCCAACATGTTACACTGTTCATGCGCTCCGGGTAATGTGCGGGCACCATGCTCAGTTCCCGCTCGCAGTTGTCACTGTCCCTGTTTCGGCACCATAATCAACATTTCCACGGCCACGCTGGTGAATAACCGAGGATACCGAAGTACAGCAAGAATGAGAGCGGGACTCCTCCATCTGCTTGTAATACGCCTTCAAGATAGTCCATAAAACGGTCGGGGTCTTGTTTCGGACTAGCCGCTTTGAAACGGTGCATAGTTGTGTCAAGTGTGGACATTGGCTTTCTATCCTCGTCAGCGATCCTCGGAAAGACTCGGGCAGTCGCCCCGAATCGTAATTAGGTAGTAGTGCGGCTCAAAAACTTCCTTCGACCTAACCGCTATAATGTTCGTAGATATAAATTTCGTTTCAGTATTAACAGGCGCACCGTATATATACGGAATGGTGTCGCCCCATTAGCTGCTCGCCAATATTTATCTAAGACCGCGCGCGTCTAGCGCCTTTAGTAGTTGCACCCGAGTATAGTAATGGGGTTCGAAGACTTCCTTCGCAAGGCTGCCATACTGTATCACAAGTACTGACGGAGCCCCGGAGGAGTGCAGGATACGGCAAAGGAGACCATTACCGGGGCATGAGTCCAAGTTAGCCCGTTAGGTGAAGGACGCTGATACAATAGTGAATCCGTTACTGAAAGGTTTAGAAGACCGGGGGGCTCGCACTAGGTCCAAATATTATGAACCCTACTCCTGCAACTGAATTGGCCGTCCAGGCGATATTTAAAAGGGGTTACTAGCAGGTTCATCGGAGCCCGTACTCCTTCCGGGCATAGTCGTTCGACGGGTAGAAATTCATCCAGTCGTGCCGGATACCCCGAGAATACCCCTATTTTTTGATCCTTCACCATCATCGTCCGCGGACTCATCTAAGTACCTCAGACCGAAACTGTTATCGTAGCGAAGAGCGAACTCGAATGACATCGCTTGTCCAACAGGGAAAATATGTAAAGTATATGCAGATTATTATAGGAAGATCACAAACTCCATCGCGCCTAGGCCAAAGACTTGCCAGAACAACATCTCTTCCAGAGCAAGGAAGTGTTTGAACCTCACTATTATCGAGAGAAGTCCCATGAATTTATAATAGTGAGGCTCAAAAACTTCCTTCATCGTCGGGCGCTGGGGCGAGCTAGGCTTCCCTAGCCGTCATTACTGTACCCACGCCAAATATTATCGAGTATGACTACGAAGCCTTCACAAGGGGCTGCAGTAACAGACTAACTCACGCACACCGCAACTACTATCCTAAATTGAGTAAGAAAACCCTCGACTATAGCCCTTGAATTAAATTCGCTATTTAAGGAAGACCGCGCTTCCGCTCGCCCGCGTATAGTTTACCAGTCCCAAGAAACATGTGTGGCCAGCCTACCTGAAGAGCTGTGTAAAGATAGATTCTGACATCCTCAAAAAGAAGTTTTCGAGCCGCACTACTACGCACGGAGCTCCGTTATTCAAGGCATGTCGAAGTACAGCGTGGTGGCCTCTCCTGTTCTCCACCCCAGCTAAACCCACCTTGTTCGAATTCGCGCAACTGTATATGACATGAACACTTACAGGGGTTAGAAGTTACTGCAACCAAGATAGAGCTCGTCGAAGTAATAGTGCGGTTCAAAAACTTCCTTCAATTGGTCTCATCACTTAAATTTAAGAGCTATTGTGAGTACAGGTACGGATGCGGCTTCAGTGGATCTTCAGCATTCATTCCTTGTAGTAATGGGGTTCGAAGACTTCCTTGCCAGGGTACCAAACAAGTCTTGCGCATCCTCCTCCCTAAGGAGGTATTTGAACCCCACTATTACCCACGATAGAACATGCAGGGTTTGATAGTGGAACACCTTTTAGAATCTGGGGATAAATTCCCAGGACTAATGTATGGCTGTAGTAATGAGGTTCAAAAACCTCCTTTTCAGGTGGATCGCAGGCCGTGCTGCCTCACAAGCTGGGACGCCGTCCACGGTATAGCCGGCGTCGGCAGTTACTGTGAAATAGCGGAAACTCGATCCCAATATATCATCTTACGTTTGGCGCCCAATAGTCGCCCAGTACCCGTTGACAGTTCTTTAACTCGGCTTAGAACTACTAGACAGGTTCAACCGAACCTTGCCCTAGTTCCCACTCCCGTAATTCATTTGGGTTTGCATCTAGAATACTGGAGGGTGCATAGACGAAACGTGTACGTCGGAGAAAACGTAAGAAAATGACCTAGACTCATAGTAGTGAGGTTCGAAGACTTCCTTTCAGTGAAATCGATCCACCACTCGCCGCGAAGAGATAATAGCATAGAGCACAAGTGCGCGAGTAGAGAAAAAGGCTATCCCAACCGGGCACGTCCTTCGTGTTTGGCGTTTACATACGGCACCCCGTTTCTGCACGTTAACCGTCTAGTATCCAACGGTGGATGGCGGACGCTAGACTATAGATATGAGATATCGAGACCTGGAGCTGGGTGTGGCTGCAGCCCGGGTCATTGCGGGCTGTGAATTCAAGGGCATGTAAACAAGCGTATATCGAACAGTGGATGGGCACCTGCAATACTCACGGTAGAGTTAGCTCACAGGATTCACGTTGAGGACTATGAGTCCCTCTTCGCTAGCAGTCTGGGGGGATATGGAGTTTAATAGCTTGACGTAGTAATGGGGCTCAAACACCTCTTTGTGTGAGCACAGCTACTTGCATTAAGAGATTCTAAACAGCGATCATCTCGGCTATTTCGGGCCAGCCTTTTCGGCAGGATGTTATGTAGCATTTCTGGAAGCTTCCCCCTCGAATCTACTAGTGGTGAGAAGATGCCCCACCGATATTACTCTTTAATCTTGAGAAACCTAAAACCGATCTGACCTCAGACGGGCGGCTCCCACCCGAGGATAAACTCGTCAATAATAATGTGGCTCGAACACTTCTTTTCTCACTAGGCTTTTACGACACGCCACATGTATTTAAGCATCTACCTAACTTGTGTCTGCTGATATACAGCGCATTCTACGCCCAACCTACCAATTACTTCAACGTAGTGCGTGGCTAAAATTCAGGGGAGCTTCATCTCTGTCTTAATTTGAAGGTTCTTCCGGGGCGTTTGGGAATCTTCGTGCCTTTTGCGAGGTTAAGGTATCAAAGAAGTTTTCGAACCACATTATTACCGCCTTAAGCACCGGCGCATCCTGCTCGTGACAACTCTACCCTGCCCTGATAAAGGCACTGAACGTTCCAGAGAGTGCATCATTGACACGCGAGCAGGCCACAGTAGCCACAAGACGTATGGGTGATTATAGAATTGGTGGAGGTGTTGTTAACGATCAGGAGGACATTAGTGGGAGTTAGGAAAGACCCTATGTTCTCTCTATCGCGGACTTGTAACTTGACAAGCAAAAGGGTAAGAGAGCTGCACACCGAAGCAGGCCCTTCCTATACCTGTTTTTCCTACGCGTAGAGAGGAATCCAGAAAGGTGATAATTGGCATTCGATGAAAAAACAGTGTGCCACTGACTTAGTTCTATATGTGAAGAGCCTGTTAGCACGTGACGGCGGCCTTGGTATAGAGCCCTTAATGGTCTCCATCGCGTAGTAATGGGGCTCGAAAACCTCCTTACTTGGGATTGCGTGGCCTCCTTGTGAGTCATACACAAGGCTTAGGGCTATGGGGCGATACACTCCTTTTCGCGGCGCATGGGGCGGTGATGCCTACATAGTAGTAGTGACTGCCTTTCTGGGGGGCTATTTGTGGATGACCAACACCTGACCAGCGATGCAATCGCTAGGGGAGGTACACCTCTCATATGTTACAACAATCACCGAATTGTGTTTCGAATTCGAATCAAGTTTGCGGTGTCGACCAGATCTGGTCTTGCTGCCATACCGGGTTCGCCGCCTCCGGTGGATAGAACTGCATCTTAAGACATCTGGACCCAGCGGTAAGTAGCGGGAAGAGTTTAGAGTCATTCGTACAACTACAGGCTAAGGGCTTACTGGGGAGTTGTTGTAGGGCATAAAGATCGCCCCATGACTTTTCGTACTTTCCCCGATAGTTCACTCGCAGCGAGCTGCGGCTGGGCTTCGCCACACGAGTACGGGCAACATTTATCTCCTCTAATCACTGGGCACCGCGCGAGGAAATAGAAAACCCTAATCAGTGCTCATGGGCGCATCTATTGGTCTCCGCATGCACGATGCCGCGGAGTGCTTAGTTGTCCCTGCATAATCTTCGTAGATGTATAAGAGATTACCTATTTATTCGGTTTCGGTTCTAGACGTACCTTGCCGCATGAGTATAGGCTAATGAACTGAGTTGGCGCCAGAGGGAAAGGCATAATAATGCGGCTCGAATACTTCCTTAAGGAAGTATTCGAACCACATTACTAT"
    val protein:String = "KEVFEPHYY";

    val substrings: Iterator[String] = getAllSubstringsEncodingProtein(genome, protein)

    Assertions.assertThat(substrings.asJava).containsOnly(
      "AAGGAAGTATTTGAGCCTCATTATTAC",
      "AAAGAGGTGTTTGAACCTCATTACTAT",
      "AAGGAGGTATTTGAACCCCACTATTAC",
      "AAAGAAGTTTTCGAACCACATTATTAC",
      "AAGGAAGTGTTTGAACCTCACTATTAT",
      "AAAGAAGTTTTCGAGCCGCACTACTAC",
      "AAGGAAGTATTCGAACCACATTACTAT",
      "ATAATAATGCGGCTCGAATACTTCCTT",
      "GTAGTAATGGGGCTCGAAAACCTCCTT",
      "GTAGTAATGAGGTTCAAAAACCTCCTT",
      "GTAGTAATGGGGTTCGAAGACTTCCTT",
      "ATAATAGTGAGGCTCAAAAACTTCCTT",
      "ATAGTAATGGGGTTCGAAGACTTCCTT",
      "GTAGTAGTGCGGCTCAAAAACTTCCTT",
      "ATAGTAATGAGGTTCGAAAACCTCTTT",
      "ATAATAATGTGGCTCGAACACTTCTTT",
      "GTAGTAATGGGGCTCAAACACCTCTTT",
      "ATAGTAGTGAGGTTCGAAGACTTCCTT",
      "GTAATAGTGCGGTTCAAAAACTTCCTT",
      "ATAGTAGTGTGGTTCAAATACCTCCTT")
  }

  "DNA" should "contain subgenomes that encodes protein - test case" in {
    val genome: String = "GTGCTTGGCAGGAATGTATCTTGCACCTTCTCAGTCAGAGCTGTGTTAGCTAACGGTCGGCACGTTTCCCGGTGGGAGCGTGTGTATACGGACGAGTGCTGGGTAACTTACAATTTTTGCCTATTTCCCATATTATTTCTCCGTGACAGGGCACGATATCCTACAGGCATGCACCTTATGTCAGTCGAATTCTAACCTAGCATAGATTTGCAATGGACGGTTAAAGGAAGACACTGGGGCAAATAGTCGGTTCCATTCAGCACATGAGCGGGGGACACCATTTCTAAAGCATGCGATCGTGTGCTACACGAACGCACCAGGTGACAAAAAGTAGATGCTAATTCTTAATGTGGTTATCAAATAGTGCGTGGGGGTTTGTAGGAAACGGTAGAAAACATTCTTGAACGGAAACTTGGTTCTCTCTCCCGTCTGGTCACCTGTCCCACTATACGTGCGTTCCACAATACGCGAGCGATAGGCTAAATATCACCCCCATTAGATTTCTCACGATACAAGCTATTTAAATCCGGTGACGACTCTTTCCTGTCAGATCAAGCTACACACGCATCTGTATGACCACCTCGAGTGGGGAGCTCTTGATAAAGGCGTAGTTATTAGGGTTGTCCCGTCGGGTCATCCCCAATAATGAAGAAACGCGTCCATCCTTCTGCGCAAATGCATACCATCCTCAAGTATAAACGCGGCGCAGCCTTGGTTAGGTGTAACCTGATTTACGAACACGGTCTCCGCATTTCCCAGCGATTAATTCGATTCTTCGTATTATTCATGCCTCCCGTTTCCTCGTTATTGGGAATAACCCGCTTTCCCGTCCGTCGCACATGGTGCGTCGGTGTGTGGCTGCGTGGACCTTGTCTCTTCGTTGTTTGGAATGACGCGAAACACCGGTCTGGAGCAGGAGACGAGCACGAGCGTCGCGCACTGGACGTAGCTAAGAGTGATACCAAATAATGAAGAGACGAAATGGGAATAAGCACTTCTCCGAGATTACGGTGGGGGAAAGTGACTTCCTTGAAAGGTCGAGAGGACACGTGCGAATCTACTGTGTATGGGGTTCAGCACTTCTACTGCCCTGGAATCGCCCAGCCATTGTACAATTACAGTACGTGATAAAACCTCGTACGGAGGAGGTGCGCCCGCTAACCGGCCGCTCATTTTACCCAGCCCTTAAGTCCCTGCTAATAGATGCGAGCACTTTCGCGAGCCATCTTCAGATATGGTCTAAACCCATGTCCAAGTTACCGCCGGATCAACACCATGAAGCTGAACGATCGCAAGAGACTAATCGTACGCCAAACTGAGGACCATCAACAGCATTGAGGACTCTGCTCTGCGGGTGCGCGGTCACCAGGCCTCCAGTATTAGTTCGTCGTGGGCTGCGCGGAGGAAATCTCTCACTAGTATAGGTTTAGTAACTTCTGCAACAGCGGCCTTTATATCCGCGTACCGCTTAGGTGTGACTAGTCAGAGGGGTTTTACTCGGGACGGTCCGAAGGCACCTGGCGGAGAGATGTCGCGTAATCCCAAACAATGAAGAGACGTTTCCTGTGGCTGTCCAACGATACGAGTGCATATGAAGGTGTTATTTTATGCTCCTGCAGACTCATTCCTCAAACGCCCATGTCCATATCCAGCGTTACAATCCCGTTGGACTTAGATTGGGCCACGTTTCCTCGTTATTCGGGATGACCCGATTACAGAGACGCACTTCCTATCCGGTGCGGCTTGTATGAAACGTCGGATGGAGCAAGAGTGTAGTCGCTGCTATGACAGCGCGAGTGATCCCTAACAACGAAGAGACTGCGAGGAGAACTTAGAGCTCCTTCATCGTCACGAAAATGTCGCGTTTTTTGCGGGGGCACGCATGGAGCAAGTGCCCACAAGCCAAGCTGCCTGGATACGCCAGCGAGCTGACGGGCACCGAGTTAACTTCGATCTGCTACATATCGCTCGGTAATGACTCACCACGGTTCGTGTTATCCCTAACAACGAGGAAACGGTCGGCACTAGCAGCCAAGATAACGGCAGGAACATACGTCAAGATAGATGTCCCAGTTTTGACAATTAGTCCGGACACACCAGTAATCTGACAACGAGTCGCGAAGGCCGCGCAGGTGATCGACTGTAGTGTGATCTTGCATCTGGTTCAGAAGGCACATCTAACTAACTCGATGAAAAGAGCTGCGGTTTCCTCCATGAATGTAACCCTGAACTGCGCCGGCTCTTGCAATCTGAAGTACCGCCACCATGCACTTGCGTACCCTGCCGCCTTCTTTGTACCCGGGACGATGTCGCAAAGCATCCTTCCTTCGTTTCGCGCCTAACCTACGGGGTTTCCAATATTGGATCGGGTTACGAAAACGCTCACTACGAGCTGTGTCTTCAACACAAATTCTATGCAGATACGTCCCAGTGATAAGAGTGTTAATATTGTGAGGACTTCCGGTTTAGCATCATATGTTTATAAGCTAACCAGGATGTTGTGATGCTGAAGCAATTAGTTTCGGTGCGAAGTCAATTAACAAGAGGTCAAGGCAGACTGTAAGTGCCACATTGAAGATCACGCGGGATTAATTGCCTCCCCTCTCAAAATCGGTCTCAATCGACGGATCGTAGAGGATCGACGCTAACCAGTATCCGTTCTGTCACAGGCAGTGTTGGGCCGTTACGGACATACGGCGACGATGGCTTCGGTCTACTTATTTAACTAGGCGTGCAGATTGATTACCCGAATCTAACGTCGACGTGGAGTGAGCGGAAGACTTCGAGCCTAAGGACGGTTCGATTCGGAAACGGAGCCTTGCATAGTACTCTAGTCCTAAGGAGTTAGATCAACTAGAACCATGGGTAATACAGCGTTAGGACCAATTGCGCGCTTAGATCATCCTAACAGGAGCATCTGCGGGGGCCTGAGGCGGCATTAGTGTGCATAGCAATATAGTAAAGGTCGTCGACCTTCAACTCAGACGAGTACATCCTTAGAGGTCTTTACACCTGGGTTGACAAACAGTTGTTTGTATGCCCTTCTACATTGCAAGGTCGAGAATTAACTGCGATGTATACAGCTTTCTTGGGAAATACGGAATCTAAATTGTTTCCGCTGGACTAGTCAGTCCGCAGCATTCTATGTATCCTGTAGGTGTCGATGATAACTCTAGAGTTAACGCTCGTTATTGAGGGGTTCGTGGGATAGCCAGCGTTCGCGCTAACTCCTGTTGCCCATCACACTGATGACTAGTCCCCCCCCTGATCCATTCCCGCTCCCGGCGCAGCCGGATTACTAAAATCCAGGCCAAATGGTAGGATCCAGAATTCCCTGAGTCCCAGCTGTGTTTCTTAAACACCCACCGTCTACTATCTCCTCTTACTGTCTGAGATACATCAGATTTTCTACCGTGGATATCCGATGTAAGGCTCAGGGAATAAGCACACGCGGACATGCCATAGGTCATTGTTGCTATAATCTCCGCGTCATCCCCAATAATGAGGAAACCATCGACTGTAAGACCAACCGTTGCCCGGGAGGTAGGTAAGTCGCGGTAGGCGTTTCCTCATTATTTGGAATTACGCGGCAGGTCTAAAGTCGTGCGAAGCAGATTCTGAGCTTTTGATCAGGTAGCGTCATCCTTAAGTACGATTTGGTGGCAAAAGGCGCCAACTCGAGCGGTGCGCGCCTCACGCTGTTACTGGGCGGACACTGTGAGCAACGCCTCTACCTTCCTCACGGTACGGTATCTACAGGCTAAAGCGAGGACGTCGGCGGATTGCGGGCTAGTACCCGTCCGCGTCGAAAGGAACTTAGGAAAGTCTAACCGAGTGAAGTGAAATAGGTCGATCTGGAAAGTTTTAGCGACTCGTGGGTAACAGCCGAAGTCTCGATTAGGCCTGGCGGGGACCCGACACTCCCTGTCTCTAAGGCCTGCGGTTTCGCGCGAATGTATAAGATCTGATACCACAATAGGAATTGTTCCCGCTGGGACCGTCTGGGATTGGTAAGTGCTCGAAAAACCGTCTCCTCGTTATTTGGAATTACACGTCCTAAAACAGGGCCAAGCTCGTGTCATCCCGAACAATGAGGAGACGAAGGACCGTCACAGATTTGATTTGCTAGGGGTCTCCTCGTTATTGGGTATCACCCTGGCCGTCAGTACGACGTTGGACAGTATAGAACCTCAATGGACCATCGAGGGTCTGCTCTCGGTCGCTGTATATAGGAACGACAAATACGGAGCTGTTTCCTTTTGATATGTTCTGGGCGAATTTCTAAAATATAGCTACATTATCCCCATTAGAGAGCTACACTACGAGGGTAGGTTGTCTAACAATGGCACAGAAGCATCAAGGAAAACTACAGAAGTCGCTTTGACCCGGTGATGAGAGGTCTGAAGGCTGCGGCGCTCTAAAAGTTCCTCAGCCGCCCCGTGGTGAGGAGGCCCCGATGACGCCGCTGCGTGGACAGGATAAGTGCGGGACGCCTCTGCAGAGGTATGAACACGGTAATATAAACGATGGATAGTTTGCAGTGGAGACGGCAGGGTTTGCTCACCTTGTAGTATCATACCCGGCTCGTGTTTAGCCTTAGTAATGACTAGAGGCTTGCACCAAGAAGCCATTATGCCACTCGAAGCTTAGCGACGAATGTTACAGTTGTACATGGGTATCCGGCGCTAACAAGCAAGTTGACAGGGTGATAAATAATTTGTGCTGCGGTCACATTGGCGCGATTCTCCCGTTCTTGAACACATCATAAGGGGCCACATAATCTTGTACGAGTTGTGGCTCGGCCTATCCACGGTGCATACCTTGACAGTAAGACAAACTACGAGATAATGTGCGAGGCCACTTGCGCCTAGCGCCTGTCGGTTGACTGAGCGTGTTAATTATAGCGGCAAACGAAATTTTGCACCGAACCATAGGGGGCGCGAGAGATACCCACGACATTTCTCGGCTAATACTCGACGGGTGCTGCCGGAGTCGTAGATAGTTTTACTTGCGATGAATTAGACTGGGGCTGTGGGTTATAGATCGCATTTATGCGCGGACCCTGTTGCCGCGTACCCGTTAAGCGTAGCCCTGTGATGTGCAACAAGCCCGGACGCCCATTTTAACCGAGTGGAGGTCCAAAAAGACCATTGCCCCTCTCTCGCCGTCTCCAACCCAAGAGCAACTTCAAAGAAGACGGTAGATCTCGGGATCTTTATCCACCTAGCAATCAAATGCAAAGGTAAATCCGCTTCGAGTATATGGTCAAAAGTCGACAAGGGGTTACTAATTGCTCTTTTGGGGGGGGGCATAGCTGCCCCATACTTCGAATGGTTCAGAACACCGTTCGTGACTACTAGTTTAAACTATGGGTGATGTCGGTTTAAGTGCTCCCTAGAATAACGGCAGGGAATCATAGCCTACACCACGAGTGATTCATTGTCTGATATCGAAAACGGATACCATGAGGGCACAAAGCTATGGTCAAGTGATTGCGTTAAGGTGGGTGCGACCAATCAAGTCTTGCCGGGTCATCCCAAATAATGAGGAAACATGAGCGCTGAATCTGCACTGGAATAGTAAGCGGGTGATACCGAATAACGAAGAAACTACGCCACATCAAGGCCCTGTCCAGCGCCCTGCATATCGAGGCATTCGCCTTCGCAAGGTGCGGAGGAAAAATGTGGATACCCGCTAAACTATGTTAGGGAGAGTGACGCTTAACTGTAGCTGGTAGAGCCTTGTGGCCGCCGCTTAATAGAGCTGTCTATTGCACAACACGACCAGCATAGTGACCCAAGAGCCCTCCACTGCTCGAACCAGTAACTATGCGGTTACACTCGCTACTAACCGTTAAGCCTCTGCGGCTCGAGGAGTGCGGGATCCTGGCGACTTGGCGGATCCGGTCGTGGGACTAGCCGGATCAAGAACACTTCCCGAGAGACGGTCGTCCGAAGTGTACTACACACGAACACCCCAGGCGGGAGACCGACCAGTGCTACAGCGAACGATGGCCGCCGAGCACAGACCAAGTTTGTAAAATTGACCGAACGGCACCATAGCCGTATAGAATGTCGTCTCTTCATTGTTGGGGATTACACGAGTAGCGCCGGATTGGTGGCAGGCAGCGCCCGAACTAGGAAAAAAGAATTCTGACTCCAGTGGCAATTTCGTCCGACGGGGAATAAGGTGCGATTTAGTTAGTTTTGGCAACGTCGGGCGCCGCTAATCCAGGGTTGTATACCGACCCCGTAGAAATAGAAAATACTAACTCACCACCTATTTTTTCCCGGGCCGCGACCAGTACTTACCCTCCGCTTTGGCCATCTGCCTAGGGCCTTGAAAGAAAATGGCTGCTCGCCCAGGATAAATCGCGGTCAGTCGTAACTCCCAGCGGCGACCGCTTGAGATGAGCTCCACCGAGTCCGCGTTATCCCTAACAACGAAGAGACCACCGCTGCGACGGCCGAGTTTCTACGCATGGAATTGGTAGTGGGAATAAACGTCGGGCAGTTAGCCTCTAGTCCGCAGATTTGTCGCTGCGTAATTAACTGCGAGGTACCGTATCGCTGATGACAAGTCTCACAGACTCGATACGGACTTGAAAACTGTTGGCTGTTGATATCACGCCAGGAGGAATGTCTCCTCATTAAGGGTTTGCACTGAAATCCGCCGCTCATAGCGGATGCATTTTGGACAATGGTATGGCCAATTCAACCAGACCCGAACCTATGGTGACTTACGCAAGGAATGGGCCCCTAAACTTCCCGGTGGGTTGAGGTTACTCTTAATGATAGGCTGCTATCGGTAGATTCTCTATGTTTGTATTCTATCCCGACTTAGCGAGCCCCTGAGACCGTCAAGTGAGCTTATTTGATACCAGTCTACCATGTGTTGCACCGTAAGACCCCTATACAGCTGCTGGGGTGACAGGACCATACTGGAATTGACGTCCATGTAAGAGCGAATATCGGCTCAGCCGCGTAATACCAAATAATGAGGAGACAAACGAAGAAACGCCAAGCTTTTCCAAGGGGCCGCTTTTAGTATAGCTGCAGTCCGGTGACGCATCGATCTTTCCACGGCGTTCAGATTATCATTCGACGAGCGGGACATCAACTGTCGGTAAACATTACTTGTTCTAATACATTTTTCTACTCCAGGTCTAGCCCGATACGCCTTAAAAGTATCACTATTATAACTCATCCCTTGACTAGGTTTCTTCGTTGTTTGGTATCACTCGGAATGCTTCGCGTCTAACAAGCGACCTGATGCTTCTTAGCAAATATCAGGTACCACCCTACGCTATATCAAAGGCCCGAGTCACCAACTTAAAGGATCGTGAGTGCCAGAGAGCCGCATTATAAGTGTTACTAATGCCTGGGTTTGCTGACAGCCGCTTACGTCCATAGTCCTAGCGTGATTCCGTAATACGATAGTCAGATGAAGACTGACCAATATAGGAGGACTCAATACGTCATGGGTTTTTCTACACCGAAGCTAGAATCCAGATTTAGCATTGACCGTAATCTATTTGACTCGTTAACCGTGATCTTACAGGGATAACTTGCGACACAACCAAATAAGCCATTAGTGAGATCGCGCTATCGCGCCGATTCGTAGTGTCCTGACCTGAATCCTACCCATGACTGATAATATAAGACCGAGAAGCCAGGCTACACGAGACCGTTCCCTACACGCTAGAACTCGAAAACGACCATTAATGTGCGGTGCAATCCGCGGACGGATGGTGATATTATATCCGAGTGACCTACGTGTAACCCCTGTTGGCCGACAGTGTGGCCGATATGTAATTACG"
    val protein:String = "RVIPNNEET";

    val substrings: Iterator[String] = getAllSubstringsEncodingProtein(genome, protein)

    println(substrings.mkString("\n"))
    Assertions.assertThat(substrings.asJava).containsOnly(
      "AAGGAAGTATTTGAGCCTCATTATTAC",
      "AAAGAGGTGTTTGAACCTCATTACTAT",
      "AAGGAGGTATTTGAACCCCACTATTAC",
      "AAAGAAGTTTTCGAACCACATTATTAC",
      "AAGGAAGTGTTTGAACCTCACTATTAT",
      "AAAGAAGTTTTCGAGCCGCACTACTAC",
      "AAGGAAGTATTCGAACCACATTACTAT",
      "ATAATAATGCGGCTCGAATACTTCCTT",
      "GTAGTAATGGGGCTCGAAAACCTCCTT",
      "GTAGTAATGAGGTTCAAAAACCTCCTT",
      "GTAGTAATGGGGTTCGAAGACTTCCTT",
      "ATAATAGTGAGGCTCAAAAACTTCCTT",
      "ATAGTAATGGGGTTCGAAGACTTCCTT",
      "GTAGTAGTGCGGCTCAAAAACTTCCTT",
      "ATAGTAATGAGGTTCGAAAACCTCTTT",
      "ATAATAATGTGGCTCGAACACTTCTTT",
      "GTAGTAATGGGGCTCAAACACCTCTTT",
      "ATAGTAGTGAGGTTCGAAGACTTCCTT",
      "GTAATAGTGCGGTTCAAAAACTTCCTT",
      "ATAGTAGTGTGGTTCAAATACCTCCTT")
  }

  def getAllSubstringsEncodingProtein(genome: String, protein: String):Iterator[String] = {
      genome.sliding(protein.length * 3, 1).filter(genomePart =>
        new DNA(DNADirection.FIVE_TO_THREE, genomePart).toRna.toProteinString() == protein ||
          new DNA(DNADirection.FIVE_TO_THREE, genomePart).secondStrand.toRna.toProteinString() == protein.reverse)
  }
}