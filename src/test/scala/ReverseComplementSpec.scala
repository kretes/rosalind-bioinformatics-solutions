import org.scalatest._

class ReverseComplementSpec extends FlatSpec with Matchers {

  "Reverse complement" should "be calculated" in {
    val genome: String = "AAAACCCGGT"

    val reverseComplementValue:String = reverseComplement(genome)

    assert(reverseComplementValue === "ACCGGGTTTT")
  }

  "Reverse complement" should "be calculated for test case" in {
    val genome: String = "CGTCCCCTGCGCCAGAGTAAACAGTGGCTCAGGTTATTGAATGATCAGCCGTCCGTCTAGATGTATTAGTTCGCCGCACTTATTTTGCCGTGAGTACCTACTGGGTTAACTCGCTGGGCGCCCTTTTGTACGCTAAACGGATGACTCACCGAACTCCGTTGGAGAGGCCACGTGCTTTGTTCCTCTCATAATTTACGGCTCCAGTCTTCAGCCTGCCCTAGTACTGAATTGGTTTGCTCATAGTCTTCCTAGCGACGAAAATAGAGCTGCGTGTATAATCTCGAGTCCGTTTCCTGAAGCCCACATTGCGCACAATGGGTACCTATTCAGCGTCCAAAAAGTGTATGATCGGTCCATAACTAAGCCTATATTCTAACAGGTAGTGGATAAACCGAAATCTTACTTACTTGATGCAGCCCGGGTGTGGAAGATACAAAAAGTGGAGTACGAATTAAACACCCGAACGGGGTTCCGTTTGTTCACGTGTCGGGGCGTCGCAGACAGTTACACAACCTGTAAATTAGCCATACTTGCCCAACACGGCCACTACACTCCACTAAGCCCGTTGGGGTTCTATAAAATCACTTGACATCCCATTGTTTTAGCTAATTACTGTCTAGTCAAAAGATTTTGGTCAACTGACTAGACACGCCACCAACGCGCCATCCGGTCAGAGTAGCCCGTCTCTGTCTTGCCGCTGCGGTAAAATGCATGCGCGCGCAGACTGCCTACCACGTATTTTCTACTTCAAAGATACGACGGCAAGGGAATAGCCCACGCTGCAATCCTCGTGGTTGACAACGCACCACCGGTCATTCGGGTTTGCGGTTACAAACATTGTGAGCAATGGACGCGTGAGCAGTGGGAAATGCCACCTCACGACCTATTCGAGCTGTTAAAGCATACTATTCCATTATGGCACCTGCTGACGTAAGTGGTTTCGGAGTAGATCATTTTGTACGCGTTCCTTTCCGTACATAGGGCAATTTCACGGTTACAGAGATTAGCTACGTGCAACACTCCAAAACTACTTTTGTATCCCGTGGGGAAATCACCTCGTACCCCAAAGCCACGCCATCTGTGTGGCGAGTCGTACCCAGGTAGGCTCTCATTGGCCACGTTTGATCCTAGAGAACTCTGACTCTGATCTGCCACACTCTTGGGGCTTCAAATCCTCCGCAAAAGGCGACAGACCACTGGTCGGAACTTCTGGGGGCGCGGTTATGCCCGACGTAAATGGGCATTCTTTTTCCTTGCTATGTGTGGAATCACGTGGATCCCCCAATGGAGTCGGCCGTCAAACTTAAAACAAGGCTGAGGAGGAGACTATCCAGTGGAGCAAGTAACTTTAGGCCCAGCCATTGAAATCTTTCTAACGGCCACGCGGAGTACGCAAACAGCATCCATTTATATCGCCGGAATGTCGGTGGTAAGGTCGCCCACAAAATATACGCGATGCCAAAACCTCAAACTTCAACGGACTAGAGAGTAGCGCAGTTCCCAGAGGTACTGTGGCCGCGTGATTTATATAAGACGAGTGAATTTCATCCCAAGATATGTTTATTTCAGTCTCGTGCTCTGGCAGTGCGGGATCACAAGTAGGACACTTGGGCAACATTAGACTATGCGGCCCCCAAGACCGCTACCATGGCGCATAATAAGTAGTAGTAGCTATAGAACGCTCTGAGCGAAAATGTCTATGCAGTCGCCTGAAAGTGAGCCATATGGCTTGGTTACCGCCTTTGCACGTTGGCCAAATTCCCTAAGTCCGTGATCACGTCAGAGTTGGTGATCAAACAACTCCTAGTGACCGGTTCATCCGTCATCTTGATTGCATATATGCATTTGACCCCAGCGAAATACGTCACGAAGTCATTTGTGATAGTGACATACAAAGACGGACGTCTGTCGATATCTACGTAATGTGCACTCTCGTACAGCCTTTCCAGTAGAATGCAATCCGTGTCACGATAAATGGGATGCCTATTTAGCAAGCAATTGAGCACGTACTCACAATGAGAAAACAGTACGTTGTCCAAAAGTGTCGATTACGAGTCTACCGACCATAGTTAAACATTGGGAGGGTTGACTTCCAGACCGTTTACAATGTTGTGTTCGTCGCTTGAACAGAACGTGTTTACGTTAAAGACTGGATAAGGCCGTAGCTGCCCAGGCCCGACTCCCCTCCTATAGAGGCCATCGCGCGCGCGTCGATGTTAGGCCTTGCTTAATGGCACTTCCTCGTTGCTCTTTCTGTCTGACTGCAGTAACCAAACCATCTATTTTTCAAGGCCGCTGAACTTAATAAAGCTCGCCGTAGGATACAGGCTCAGCGCTATAGCGCACTACGACCACGTCGACATAACACCTAAGGCTTTGAACTTCTCGTGTTGGATCGGTATACTTGTGACCTCGGAAATCCGCCTTAGTCCTCTGCGGAATGCGTATCTCCTACGGGGCCAGCTCTTAAATTCTGCGGTACCACTTTCATAAGGTGTTTTAATCGTCGAGTTTTCAGCGCTATGTAGCCCCGGTGTTTGTTGACCTAAATGTACGTGCCCGGCTTGATAGGTCACTACGCACAACACTTAACATGATCCAGGGCGAGGGAAACGGGCGTAGAAGAATCATTGTACAGGAGATCATGGCTAATACATAATGGTACGAGTGGGCCTAGCCGATCGTATAATCTCATCGCCACTCCCGAGTGGGCCCAGTCCTATCTCACGCGCAGTTGCTCGCACGCCGCGCGCCAGGGGTTTGGTGACTGTTACCACAGAGCGTTGCACCTTAATCCGAGAACGCCGAATGGGGTCCAAGTTTATCCAGCCGGCGCCCAGCGATTACCCGCGAAATTGATGGTATTTATACATGCAATGGATCATTATAGGGACATGGCCCGTATAAACGCCGCTCTATTTTCTGAATGTTCCCTGCGGTGTTGGGTCGCCGTGACTTGCATGCCACTCTGGGAGCTCATGAGCATTTTCATGACAGTTGATGCACAGTCATATAGGGCCTGCATGAGGGCATAACCCTAGATCTCGACTTTGGACGCGCCAACTGTCCTTGCCAGAGAGATACAGTCCATGAGAATTCGGAACGCCGGAGGTGCCGACGAATTGTGAGAGGCATGACTGGGGCGAGTCCTTGTCACCCAAAATCCGTTTATACTAAGTCTTGACCCACAATCCAGATCAACTGTGTGAGGTCCCCGATCCCGAGTTCCCTTGTACCTTAGGTCCGACCTCATCACGCACCTTCAGGGGGCATATCCGCGACTGTTAAGCATGAATACCCTGATCGATAATGTAGTGTTACCCACAGCGTATAGTTTACATACATTAGAAGGCAAGACCCTTTGTCTAAGCTAATCGTGCACCGCTGGCGTAATTTATGAATTACCAAAGTTAACTATTGTTGCTGGACGAGCCACGATCCGCTTGCGCCCTGCCTTTAAATCGTGACTAGTTATTAGAATCCAGATCAATTGGTTGCAGTTAATCCTCACTATAGCCGCATTAGATCTGGGACCAAACCCTATGAGGGTGGAAGTCCGAAAACGGTCAACTGACTCGTCAGTGTCGGGTTTGCGCGGCCAGGGCCCTTGTGAGTTTTCGACAAGTTCCCGCCACGGAACGAATGCGCCATAGTCGTTCCAAGTCCAAGCCATCTATTCCTTAAGAGTAGAATACGTGTGGCTCTCTTCCCCCCATTGGGTAAGAACGAGAGTACTTCATGCCGTCTGGTAGCTGTGTTACTCTAACATGAAATACTGTCTGATGAGATAGTCCCACTAGTTAGTAACAAATGTAGATCTAACAAACTCCTTCAGCTACTAGCGATAAGCTACTGGAGAGCTTAATTTCCGCCCGCCAGCGTTTGTGTCGCACGCGCATCTAGTAATGTGTAATCAAAACTCCGCTTAAATATCTAAGGAAGCGGCTGACAAGTGATCAGCCACAGTCCACTCCACTACCCGTGTACAGTACTAGTGGGCTCGCCATTTAAGCCCCTGATAAACTACTAATAGGCGGAAAATATATAGATGTCCTAACATTAGCGTAAAGACTCGGTCACGTCGCGCGTTTACCTATCAGGTCTACCATTGAAGGTAATCGGCCCAGAATACGCACAGACTTACTTGCGGTGGTGCGCTGAAGTACACGCCTAGCCCCCCCGCAGGAACACGTTGACTTATCGTGAGAATTTACCGGTTAGAGGATGCTCGTCTGTGGGTAATTTGAGCCTATGGGCAGCAGCGATTACGTTCGAGTGTCCAGTTAACGCTGGTGCACAAGCGGTTCGAGGGATCATCTTAAGGTACCTGATTTAGGCGTTGTTAGTGAGCAGTAGTCAATAAGGGATATTCGTGAAAAATACCATGATCCAGGAGATCGGCATTGGGAACATGCTTTATGTTATTTTGTCTTGGCAGTGGGTCCCGCTAGGCCACGAAGCTGTGTAACATACCAACCACCACGATAGATGGGAAATACTAATGAGGAGACCAAGGGCTCTGTACCAATTAGGCCTTACTTCCGCGGCTTGGAATTTATGAGTGTAGATCAATCCATGACTTGCCACGCAAGCGGGTACGCCCATACTTTTGATAAAAGCATAGCGGGTAAAAACACACCAGTACCCGTAAAGGATGCCATCGTCGGCGCCTGTGCCCGTCTCCCGCTATCCACAAGCTCCTATCTAGGCAACATTTGGCGAAGTGGGTAGCTCGAAAGTTACGACAAGACGCTTACCCATATATATAATATACGAGAGCGGATGAATTCCGCATCCAATCCGGTTGAACCAAGCAAGCTCGTCAGCATGTTGCCTCCTAAAGGCAATTGGCCACTCCACCTACTATAGCCTTTATTCATAAGTTGTCTGCATCCCTGCTTAATGAGCGAGAGAGTCTAGTCCCGCTTGATGCTATCTGCATTGTTGCCTCCTGTTATTCGACGACTTGGGCTTTGGAGTCAGTGGGTCCACTGCATGTAAGGGTGCTTTGGGGCCGGATAAATACGAGACCTATCAGGATCGGGTGGCGTTAAGAGGGCGAACAAAGATGGGTACCAAGCGCATATAGCTAATGTAGAGTTGATTCTTGCGGGTAGAGATGATATAATTAAAGCCAGGAGGACCATACTGGCGCACTCCCTGCAGGGGAGGAGCCCACACAGGCCGAGTGGATCGTTGGCTCCTTGTACAGCCGCGAAAGATTGGAACGTTTACTTCTCCACGGCCCGTCATGCTTAGCCTCGACACGCCAGGGGAACTCTTACGTGACAGAAATGCAACTAGACCCGGGAGTCTCGCTTTACCTCGCATCTAGGCACGCATCTCTCCTTTTTAAATGGAAACATCAACGAAGTATCCTCATCGTGACCTGGTGCCCCGCTGGGTTAAAGATGCGCAAGACACAACTTGCGTAATTAGTGATAAACGTCAAAGGAGACCAATGCCTTTCTCCTTCTACAGCACCGTAGACCCGTGGACAAGATCGTATCACCCTGAGAGGAATTCTTCTGGCGTGCACAAGGCGCTCGGGAGGTCGATAGTTAAGACGCTCTGATTACTGGCTTGCAAATATTAAGGCGTGGCGTTTCCAACCGTTCAGTGGAGTATTGCGGTTTGCACCATCCACAGGGGCTCCTCTGAACTGGAGGTTTCATCGACGGTATCATCTTATAGCCTTGCGTCGAACAGTGCACGAACCGTTAGCCCCTAACGCGTCGTAGAACGACATCAGACAGTCAAATCACTTTCACTAGGCTGTGTGCGCTAGTTGTTTCTTTAGCGAAGTTTTGTCGAATGCTGGGGTAATGGACCATGATCCTTGCCCCCACTGTATGCGCGAAGGTATGTAGCTTCCACACGACCGTCTAGTCAGTATAGGCTTACGCTAGTGCGCCGTATCGCTGTGTCGTCCTTAGGTCGGAGGAGTCGATTGGCGTCCCTGCGCCGCGTCCAACAGTCATCAGGAAAGCGAGCTGGATTCAGTCGTCACTCTCTGATAGCTCAAACTTGAACGAGCAGGAGGAGAGGGGCCACGCTCACCCTCCCAATGCCAGTCTTCTTGCTCCTGGACCTGTTGGACAGAACTGCCTGATAGTAGAGTCATGTCAAAGCACCACGTTGTATAGAATCGGTGCTTGTATGAATTGCTAATAAATAACGAGTATAAATTGCAACGTAGAGCTTGCCCCACGGGAGCGTCTGAAGATATTCCCTCTGTGTGATTCACTACTTGGCGCCCGTTGAACCTTCAACCGTTACCTTTGCCACCGAGACCTCGTAGTCGTGCGTAGTATATACATTGCGTCTAGACGATTAACGCTACGAGCAGCAGAGAAGATGGTACTGAGGCGGCTCACATTTCGTAAGGACTGACTAGTTTGGCAACTTGCGAAGTCGCATCTATACGCCCTCTCTCGCCATGTCAGTGGCCGCCGGCTGGAAGTATCTAGTTCTGCTGGTTTTCGTTCCGTCTGATACGATTGCGAGTCGGGTATGAAGCTCCCCAATCACCACTCGCTCCTCAATGGTGTGGTTTAGCGTTGGAATTCGTAACGACTGCTCTGACTGGCAGTTATGTTCAGCAGGTCTTCTCTCAGAAGCCCGCGTAACGTCCAGACTATTGTATAAAGTAGGCTCCACTGGCTGCGAGATACCCTGACTGTTATAGATAACTCGTACCCGCTCGTATAGCCATGACTATATGGTGCTCTAGAAGACCTACAGTTTCTGGGGTCCCGCGCCTGCTAGAAAAGAGACCGACTAGCCGGCAGTTACATGCGAGATACGCAGCGCCTATACGAGGCAGGATTCGGAAGAGCCGACAGTACCTCCTTGCAGCTAACATGTTTCGCGATGTGATCCCTCAAACATACTGTGTCGGTCGTTCTACTGGCCTCGTCGGGGTTTGGATCTCCGGGGGCGGACGGTCGACTTCTCTAAGTCTCCTAGTTCACATAATGGTCTCCTGACCTCGTCAGGGGCCCACGCCTACCGCGTCTCTCAGGAGCGACGGGCGTCAGCATAGTCGCCCTTCAAAACAATAATGTTCAAGTTTTCCGGACGGGGCCCCGCACTAACCATGCAGAGAGAAGAGGAAATGGTGGGATGCGTGCGGGATTTATTGTTTGTCATACATGAACGTCTGCAATGGACCGAATTTTGAAGGACGAATACACGGTGTATTGTGGTAATAGAAAAATCTAATCTCTTCTGAGTAAATGTCCGTCTCGGCCAGGCAAGTCAGGAAGGGCCCAGTCCCAGCAGCAGTACATATCGTGGGAACAGTAAGACTGCGCCTTCGGTACGCGCACTCGCTGCATTCACATAACAGGCTATTGCTATCCACCTTCGCCTGAGATGGGCCAGCATTAGCTTGGAAGTTTCAGTTAGGCTCTATATGTTTTTTCCCTCTACTCCCCTGCAGGTTAGAATTACTATGAAGTACTGTGAAGTGCTCCACCGAGTGAACTTGATCTCTATTAACACAGTTAGTCCAAAGCTAGATTAAGCGGTCTAAAACATACCCCAACACGGGCAGATGAGTAGCCACACCCGGTGTCGCGTATATAGTTGAGTTTTTACTAACTGGGGTGACTTACGCACACGGATATGCGGCCGATAACGAGTAACTGGCTGCACCACCGGCCTTCAGAGGGAGAACTTGCCCTTGTAAACCAAGTGCACGGACGAGAAAGATACCA"

    val reverseComplementValue:String = reverseComplement(genome)

    assert(reverseComplementValue === "TGGTATCTTTCTCGTCCGTGCACTTGGTTTACAAGGGCAAGTTCTCCCTCTGAAGGCCGGTGGTGCAGCCAGTTACTCGTTATCGGCCGCATATCCGTGTGCGTAAGTCACCCCAGTTAGTAAAAACTCAACTATATACGCGACACCGGGTGTGGCTACTCATCTGCCCGTGTTGGGGTATGTTTTAGACCGCTTAATCTAGCTTTGGACTAACTGTGTTAATAGAGATCAAGTTCACTCGGTGGAGCACTTCACAGTACTTCATAGTAATTCTAACCTGCAGGGGAGTAGAGGGAAAAAACATATAGAGCCTAACTGAAACTTCCAAGCTAATGCTGGCCCATCTCAGGCGAAGGTGGATAGCAATAGCCTGTTATGTGAATGCAGCGAGTGCGCGTACCGAAGGCGCAGTCTTACTGTTCCCACGATATGTACTGCTGCTGGGACTGGGCCCTTCCTGACTTGCCTGGCCGAGACGGACATTTACTCAGAAGAGATTAGATTTTTCTATTACCACAATACACCGTGTATTCGTCCTTCAAAATTCGGTCCATTGCAGACGTTCATGTATGACAAACAATAAATCCCGCACGCATCCCACCATTTCCTCTTCTCTCTGCATGGTTAGTGCGGGGCCCCGTCCGGAAAACTTGAACATTATTGTTTTGAAGGGCGACTATGCTGACGCCCGTCGCTCCTGAGAGACGCGGTAGGCGTGGGCCCCTGACGAGGTCAGGAGACCATTATGTGAACTAGGAGACTTAGAGAAGTCGACCGTCCGCCCCCGGAGATCCAAACCCCGACGAGGCCAGTAGAACGACCGACACAGTATGTTTGAGGGATCACATCGCGAAACATGTTAGCTGCAAGGAGGTACTGTCGGCTCTTCCGAATCCTGCCTCGTATAGGCGCTGCGTATCTCGCATGTAACTGCCGGCTAGTCGGTCTCTTTTCTAGCAGGCGCGGGACCCCAGAAACTGTAGGTCTTCTAGAGCACCATATAGTCATGGCTATACGAGCGGGTACGAGTTATCTATAACAGTCAGGGTATCTCGCAGCCAGTGGAGCCTACTTTATACAATAGTCTGGACGTTACGCGGGCTTCTGAGAGAAGACCTGCTGAACATAACTGCCAGTCAGAGCAGTCGTTACGAATTCCAACGCTAAACCACACCATTGAGGAGCGAGTGGTGATTGGGGAGCTTCATACCCGACTCGCAATCGTATCAGACGGAACGAAAACCAGCAGAACTAGATACTTCCAGCCGGCGGCCACTGACATGGCGAGAGAGGGCGTATAGATGCGACTTCGCAAGTTGCCAAACTAGTCAGTCCTTACGAAATGTGAGCCGCCTCAGTACCATCTTCTCTGCTGCTCGTAGCGTTAATCGTCTAGACGCAATGTATATACTACGCACGACTACGAGGTCTCGGTGGCAAAGGTAACGGTTGAAGGTTCAACGGGCGCCAAGTAGTGAATCACACAGAGGGAATATCTTCAGACGCTCCCGTGGGGCAAGCTCTACGTTGCAATTTATACTCGTTATTTATTAGCAATTCATACAAGCACCGATTCTATACAACGTGGTGCTTTGACATGACTCTACTATCAGGCAGTTCTGTCCAACAGGTCCAGGAGCAAGAAGACTGGCATTGGGAGGGTGAGCGTGGCCCCTCTCCTCCTGCTCGTTCAAGTTTGAGCTATCAGAGAGTGACGACTGAATCCAGCTCGCTTTCCTGATGACTGTTGGACGCGGCGCAGGGACGCCAATCGACTCCTCCGACCTAAGGACGACACAGCGATACGGCGCACTAGCGTAAGCCTATACTGACTAGACGGTCGTGTGGAAGCTACATACCTTCGCGCATACAGTGGGGGCAAGGATCATGGTCCATTACCCCAGCATTCGACAAAACTTCGCTAAAGAAACAACTAGCGCACACAGCCTAGTGAAAGTGATTTGACTGTCTGATGTCGTTCTACGACGCGTTAGGGGCTAACGGTTCGTGCACTGTTCGACGCAAGGCTATAAGATGATACCGTCGATGAAACCTCCAGTTCAGAGGAGCCCCTGTGGATGGTGCAAACCGCAATACTCCACTGAACGGTTGGAAACGCCACGCCTTAATATTTGCAAGCCAGTAATCAGAGCGTCTTAACTATCGACCTCCCGAGCGCCTTGTGCACGCCAGAAGAATTCCTCTCAGGGTGATACGATCTTGTCCACGGGTCTACGGTGCTGTAGAAGGAGAAAGGCATTGGTCTCCTTTGACGTTTATCACTAATTACGCAAGTTGTGTCTTGCGCATCTTTAACCCAGCGGGGCACCAGGTCACGATGAGGATACTTCGTTGATGTTTCCATTTAAAAAGGAGAGATGCGTGCCTAGATGCGAGGTAAAGCGAGACTCCCGGGTCTAGTTGCATTTCTGTCACGTAAGAGTTCCCCTGGCGTGTCGAGGCTAAGCATGACGGGCCGTGGAGAAGTAAACGTTCCAATCTTTCGCGGCTGTACAAGGAGCCAACGATCCACTCGGCCTGTGTGGGCTCCTCCCCTGCAGGGAGTGCGCCAGTATGGTCCTCCTGGCTTTAATTATATCATCTCTACCCGCAAGAATCAACTCTACATTAGCTATATGCGCTTGGTACCCATCTTTGTTCGCCCTCTTAACGCCACCCGATCCTGATAGGTCTCGTATTTATCCGGCCCCAAAGCACCCTTACATGCAGTGGACCCACTGACTCCAAAGCCCAAGTCGTCGAATAACAGGAGGCAACAATGCAGATAGCATCAAGCGGGACTAGACTCTCTCGCTCATTAAGCAGGGATGCAGACAACTTATGAATAAAGGCTATAGTAGGTGGAGTGGCCAATTGCCTTTAGGAGGCAACATGCTGACGAGCTTGCTTGGTTCAACCGGATTGGATGCGGAATTCATCCGCTCTCGTATATTATATATATGGGTAAGCGTCTTGTCGTAACTTTCGAGCTACCCACTTCGCCAAATGTTGCCTAGATAGGAGCTTGTGGATAGCGGGAGACGGGCACAGGCGCCGACGATGGCATCCTTTACGGGTACTGGTGTGTTTTTACCCGCTATGCTTTTATCAAAAGTATGGGCGTACCCGCTTGCGTGGCAAGTCATGGATTGATCTACACTCATAAATTCCAAGCCGCGGAAGTAAGGCCTAATTGGTACAGAGCCCTTGGTCTCCTCATTAGTATTTCCCATCTATCGTGGTGGTTGGTATGTTACACAGCTTCGTGGCCTAGCGGGACCCACTGCCAAGACAAAATAACATAAAGCATGTTCCCAATGCCGATCTCCTGGATCATGGTATTTTTCACGAATATCCCTTATTGACTACTGCTCACTAACAACGCCTAAATCAGGTACCTTAAGATGATCCCTCGAACCGCTTGTGCACCAGCGTTAACTGGACACTCGAACGTAATCGCTGCTGCCCATAGGCTCAAATTACCCACAGACGAGCATCCTCTAACCGGTAAATTCTCACGATAAGTCAACGTGTTCCTGCGGGGGGGCTAGGCGTGTACTTCAGCGCACCACCGCAAGTAAGTCTGTGCGTATTCTGGGCCGATTACCTTCAATGGTAGACCTGATAGGTAAACGCGCGACGTGACCGAGTCTTTACGCTAATGTTAGGACATCTATATATTTTCCGCCTATTAGTAGTTTATCAGGGGCTTAAATGGCGAGCCCACTAGTACTGTACACGGGTAGTGGAGTGGACTGTGGCTGATCACTTGTCAGCCGCTTCCTTAGATATTTAAGCGGAGTTTTGATTACACATTACTAGATGCGCGTGCGACACAAACGCTGGCGGGCGGAAATTAAGCTCTCCAGTAGCTTATCGCTAGTAGCTGAAGGAGTTTGTTAGATCTACATTTGTTACTAACTAGTGGGACTATCTCATCAGACAGTATTTCATGTTAGAGTAACACAGCTACCAGACGGCATGAAGTACTCTCGTTCTTACCCAATGGGGGGAAGAGAGCCACACGTATTCTACTCTTAAGGAATAGATGGCTTGGACTTGGAACGACTATGGCGCATTCGTTCCGTGGCGGGAACTTGTCGAAAACTCACAAGGGCCCTGGCCGCGCAAACCCGACACTGACGAGTCAGTTGACCGTTTTCGGACTTCCACCCTCATAGGGTTTGGTCCCAGATCTAATGCGGCTATAGTGAGGATTAACTGCAACCAATTGATCTGGATTCTAATAACTAGTCACGATTTAAAGGCAGGGCGCAAGCGGATCGTGGCTCGTCCAGCAACAATAGTTAACTTTGGTAATTCATAAATTACGCCAGCGGTGCACGATTAGCTTAGACAAAGGGTCTTGCCTTCTAATGTATGTAAACTATACGCTGTGGGTAACACTACATTATCGATCAGGGTATTCATGCTTAACAGTCGCGGATATGCCCCCTGAAGGTGCGTGATGAGGTCGGACCTAAGGTACAAGGGAACTCGGGATCGGGGACCTCACACAGTTGATCTGGATTGTGGGTCAAGACTTAGTATAAACGGATTTTGGGTGACAAGGACTCGCCCCAGTCATGCCTCTCACAATTCGTCGGCACCTCCGGCGTTCCGAATTCTCATGGACTGTATCTCTCTGGCAAGGACAGTTGGCGCGTCCAAAGTCGAGATCTAGGGTTATGCCCTCATGCAGGCCCTATATGACTGTGCATCAACTGTCATGAAAATGCTCATGAGCTCCCAGAGTGGCATGCAAGTCACGGCGACCCAACACCGCAGGGAACATTCAGAAAATAGAGCGGCGTTTATACGGGCCATGTCCCTATAATGATCCATTGCATGTATAAATACCATCAATTTCGCGGGTAATCGCTGGGCGCCGGCTGGATAAACTTGGACCCCATTCGGCGTTCTCGGATTAAGGTGCAACGCTCTGTGGTAACAGTCACCAAACCCCTGGCGCGCGGCGTGCGAGCAACTGCGCGTGAGATAGGACTGGGCCCACTCGGGAGTGGCGATGAGATTATACGATCGGCTAGGCCCACTCGTACCATTATGTATTAGCCATGATCTCCTGTACAATGATTCTTCTACGCCCGTTTCCCTCGCCCTGGATCATGTTAAGTGTTGTGCGTAGTGACCTATCAAGCCGGGCACGTACATTTAGGTCAACAAACACCGGGGCTACATAGCGCTGAAAACTCGACGATTAAAACACCTTATGAAAGTGGTACCGCAGAATTTAAGAGCTGGCCCCGTAGGAGATACGCATTCCGCAGAGGACTAAGGCGGATTTCCGAGGTCACAAGTATACCGATCCAACACGAGAAGTTCAAAGCCTTAGGTGTTATGTCGACGTGGTCGTAGTGCGCTATAGCGCTGAGCCTGTATCCTACGGCGAGCTTTATTAAGTTCAGCGGCCTTGAAAAATAGATGGTTTGGTTACTGCAGTCAGACAGAAAGAGCAACGAGGAAGTGCCATTAAGCAAGGCCTAACATCGACGCGCGCGCGATGGCCTCTATAGGAGGGGAGTCGGGCCTGGGCAGCTACGGCCTTATCCAGTCTTTAACGTAAACACGTTCTGTTCAAGCGACGAACACAACATTGTAAACGGTCTGGAAGTCAACCCTCCCAATGTTTAACTATGGTCGGTAGACTCGTAATCGACACTTTTGGACAACGTACTGTTTTCTCATTGTGAGTACGTGCTCAATTGCTTGCTAAATAGGCATCCCATTTATCGTGACACGGATTGCATTCTACTGGAAAGGCTGTACGAGAGTGCACATTACGTAGATATCGACAGACGTCCGTCTTTGTATGTCACTATCACAAATGACTTCGTGACGTATTTCGCTGGGGTCAAATGCATATATGCAATCAAGATGACGGATGAACCGGTCACTAGGAGTTGTTTGATCACCAACTCTGACGTGATCACGGACTTAGGGAATTTGGCCAACGTGCAAAGGCGGTAACCAAGCCATATGGCTCACTTTCAGGCGACTGCATAGACATTTTCGCTCAGAGCGTTCTATAGCTACTACTACTTATTATGCGCCATGGTAGCGGTCTTGGGGGCCGCATAGTCTAATGTTGCCCAAGTGTCCTACTTGTGATCCCGCACTGCCAGAGCACGAGACTGAAATAAACATATCTTGGGATGAAATTCACTCGTCTTATATAAATCACGCGGCCACAGTACCTCTGGGAACTGCGCTACTCTCTAGTCCGTTGAAGTTTGAGGTTTTGGCATCGCGTATATTTTGTGGGCGACCTTACCACCGACATTCCGGCGATATAAATGGATGCTGTTTGCGTACTCCGCGTGGCCGTTAGAAAGATTTCAATGGCTGGGCCTAAAGTTACTTGCTCCACTGGATAGTCTCCTCCTCAGCCTTGTTTTAAGTTTGACGGCCGACTCCATTGGGGGATCCACGTGATTCCACACATAGCAAGGAAAAAGAATGCCCATTTACGTCGGGCATAACCGCGCCCCCAGAAGTTCCGACCAGTGGTCTGTCGCCTTTTGCGGAGGATTTGAAGCCCCAAGAGTGTGGCAGATCAGAGTCAGAGTTCTCTAGGATCAAACGTGGCCAATGAGAGCCTACCTGGGTACGACTCGCCACACAGATGGCGTGGCTTTGGGGTACGAGGTGATTTCCCCACGGGATACAAAAGTAGTTTTGGAGTGTTGCACGTAGCTAATCTCTGTAACCGTGAAATTGCCCTATGTACGGAAAGGAACGCGTACAAAATGATCTACTCCGAAACCACTTACGTCAGCAGGTGCCATAATGGAATAGTATGCTTTAACAGCTCGAATAGGTCGTGAGGTGGCATTTCCCACTGCTCACGCGTCCATTGCTCACAATGTTTGTAACCGCAAACCCGAATGACCGGTGGTGCGTTGTCAACCACGAGGATTGCAGCGTGGGCTATTCCCTTGCCGTCGTATCTTTGAAGTAGAAAATACGTGGTAGGCAGTCTGCGCGCGCATGCATTTTACCGCAGCGGCAAGACAGAGACGGGCTACTCTGACCGGATGGCGCGTTGGTGGCGTGTCTAGTCAGTTGACCAAAATCTTTTGACTAGACAGTAATTAGCTAAAACAATGGGATGTCAAGTGATTTTATAGAACCCCAACGGGCTTAGTGGAGTGTAGTGGCCGTGTTGGGCAAGTATGGCTAATTTACAGGTTGTGTAACTGTCTGCGACGCCCCGACACGTGAACAAACGGAACCCCGTTCGGGTGTTTAATTCGTACTCCACTTTTTGTATCTTCCACACCCGGGCTGCATCAAGTAAGTAAGATTTCGGTTTATCCACTACCTGTTAGAATATAGGCTTAGTTATGGACCGATCATACACTTTTTGGACGCTGAATAGGTACCCATTGTGCGCAATGTGGGCTTCAGGAAACGGACTCGAGATTATACACGCAGCTCTATTTTCGTCGCTAGGAAGACTATGAGCAAACCAATTCAGTACTAGGGCAGGCTGAAGACTGGAGCCGTAAATTATGAGAGGAACAAAGCACGTGGCCTCTCCAACGGAGTTCGGTGAGTCATCCGTTTAGCGTACAAAAGGGCGCCCAGCGAGTTAACCCAGTAGGTACTCACGGCAAAATAAGTGCGGCGAACTAATACATCTAGACGGACGGCTGATCATTCAATAACCTGAGCCACTGTTTACTCTGGCGCAGGGGACG")
  }

  def reverseNucleotide(c: Char): Char = {
    c match {
      case 'A' => 'T'
      case 'T' => 'A'
      case 'C' => 'G'
      case 'G' => 'C'
    }
  }

  def reverseComplement(genome:String): String = {
      return genome.foldRight("")((nucleotide:Char,reversed:String) => reversed + reverseNucleotide(nucleotide));
  }

}
