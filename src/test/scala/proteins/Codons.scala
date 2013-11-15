package proteins

/**
 * Created with IntelliJ IDEA.
 * User: tomasz
 * Date: 11/13/13
 * Time: 12:52 AM
 * To change this template use File | Settings | File Templates.
 */
class Codons {

  def codonToAmino(codon:String ) = {
    codon match  {
    case "AAA" => "K"
    case "AAC" => "N"
    case "AAG" => "K"
    case "AAU" => "N"
    case "ACA" => "T"
    case "ACC" => "T"
    case "ACG" => "T"
    case "ACU" => "T"
    case "AGA" => "R"
    case "AGC" => "S"
    case "AGG" => "R"
    case "AGU" => "S"
    case "AUA" => "I"
    case "AUC" => "I"
    case "AUG" => "M"
    case "AUU" => "I"
    case "CAA" => "Q"
    case "CAC" => "H"
    case "CAG" => "Q"
    case "CAU" => "H"
    case "CCA" => "P"
    case "CCC" => "P"
    case "CCG" => "P"
    case "CCU" => "P"
    case "CGA" => "R"
    case "CGC" => "R"
    case "CGG" => "R"
    case "CGU" => "R"
    case "CUA" => "L"
    case "CUC" => "L"
    case "CUG" => "L"
    case "CUU" => "L"
    case "GAA" => "E"
    case "GAC" => "D"
    case "GAG" => "E"
    case "GAU" => "D"
    case "GCA" => "A"
    case "GCC" => "A"
    case "GCG" => "A"
    case "GCU" => "A"
    case "GGA" => "G"
    case "GGC" => "G"
    case "GGG" => "G"
    case "GGU" => "G"
    case "GUA" => "V"
    case "GUC" => "V"
    case "GUG" => "V"
    case "GUU" => "V"
    case "UAA" => " "
    case "UAC" => "Y"
    case "UAG" => " "
    case "UAU" => "Y"
    case "UCA" => "S"
    case "UCC" => "S"
    case "UCG" => "S"
    case "UCU" => "S"
    case "UGA" => " "
    case "UGC" => "C"
    case "UGG" => "W"
    case "UGU" => "C"
    case "UUA" => "L"
    case "UUC" => "F"
    case "UUG" => "L"
    case "UUU" => "F"
    }
  }
}