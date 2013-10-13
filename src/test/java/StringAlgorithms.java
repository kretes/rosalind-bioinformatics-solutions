import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.OptionalDataException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAlgorithms {

    @Test
    public void shouldCalculateNucleobaseCount() {
        String genome = "GCACATAAAGGGCACTTTACAACTTACCTGTTCACATAGGGGGTATCGAATATTACGTTGTTGTAGCGTCTACTGCACACGGGGTTTAGAACTAAAATAATCGTTATTGGATTGTTACCCGCTCTGTGAATAAGCGTAGATTAGCCTGACGAATATATAGTCGTGGCGTCACCCTTTGCCTTCGTAGTGGTGCAAACGTAATTAGGATGGAAACAACCCTAGCCATGCCAGGACTGCCATGTATAACTTTCGCTGCTATGAGCATGGTGCCTTTCGGAGGGTACCGAGTATGCCATCCGAGTGCGATTTGAGCTTGTACTTCATTGCGCTCACATTGGCGTCGACCCCGGGGCAAGCGTTTACCTAACACAGAAGGCATTGCCTAGCCGCCATCACCAGTACGTTCGTCCACAACGTTGCTTGAGACGGGACCACTATAACTTCTGGACCAGATAAATGAGCTGAGGTTAATAACCTACCCTGACGCTTCATGTAACAGCAACGGACTGTGAGCGGATCGTCCTTTTCTCTACTTTTTGTCACCTTCCTTTACACTCGAATTCCTCCGATCGCACTAGGCTTCCCTCGCCATCGTAGTCGTAACATGTAAGCATCATCTCGAGTAAGCACAGTTGCGGTGTGACGAACTTGCTGGCGAGATACCGACTCGACATAACAGCGACTTTTTTTATTCGGTCGTAGAATGTCGGATGCAGAAAACTCTATTCAACCTCCCTGGACGTGATAAAAGCATTATGAGCCATGTCGCGTGTTTTCTAAGATGTTTAGTTGCGTCGCAAGTTTGTGCACTAAGCTACCCTTTTCCTTCTATAGTTACGTTTGACTAC";

        Map<Character,Integer> nucleobaseCount = new HashMap<Character, Integer>();
        for (char nucleobase : genome.toCharArray()) {
            if(nucleobaseCount.containsKey(nucleobase)) {
                nucleobaseCount.put(nucleobase,nucleobaseCount.get(nucleobase)+1);
            } else {
                nucleobaseCount.put(nucleobase, 1);
            }
        }

        String output = nucleobaseCount.get('A') + " " + nucleobaseCount.get('C') + " " + nucleobaseCount.get('G') + " " + nucleobaseCount.get('T');
        System.out.println(output);
        assertThat(output).isEqualTo("207 208 191 242");

    }

    @Test
    public void shouldTranslateDNAtoRNA() throws Exception {
        String dna = "TTCCCCCAATGGGGTGAAAGATTACGGGGCCAAGTCTCAATCGGCATTTGGTTTTCGCTTGGAGCTTAACTGCATCCATGTCTGTACTTATCCTGTTGTTCCTTGAGAGGACAATCGTACGATCACACCGGGGTTAGAAAATTTTATAAAGCAAGACAGAACATACGTCACCAAACAACGAGACCAGTATAGGGGCAAACGGTGATAGTGTCGTATTATGAGTTCGAAGAGGGGCAAGGGGGAGAAGCGGTAATGGTACCGAGTAAAATCTTTTCATGAAGAAACCTACTCCTTCTTATGTCCTCTCATGTATCATTCCACGGGAGGTGGCCGACGTTTCTGACTCAATAACGGTACGCCTACAAATTAGCCGGAGGTAGGACCCCGCGGAGCTGCTTCCCAGATGACGACATTCGCTGATCCCCCTTAGCATATTTGACTGCAACTCGGGTGGTGTATGGTTCCCCTATCAGCTGACAATAATCAGACAGGATGACACCACGAAACACTAATAATAATATCCGAGTCTATATCTTGGTTCCGGCAGCCGTCTAAGAGCTCTTTGACGAGACTGCATACGGGCGATCACGCTATCGCTTAGAGTAGTTTTGTCGGATTCAGACGTGAGCTGGCCTCGATGAGTAGCTTGTTTATGTAAGACGACTTAGGCAGCGCGTGTGCCGAAGCACGATCTCACTGCACAATAGTTAAGTAGAGAGTGGCTCTGGAGGGGCCCGGGTAGACAAGCTTAAGGTATTGGTGTATCTTTTCAACGGGTCCTAATTCGTATACTTGGCCAACTCACGTTTCCCGGGGCATACACACCTTGAAAAGTTCACACTGCACGTATGTCCTCATACATACATCACGGCCTACAGCTTGCCAGTTGGCCGAGATCGGGGATGGCAAATAAGGGAGATAACGTCGCGAAGACGACTCCTCCTGTCACTCGCCCTGTCGCGATAGGCAAACACG";

        String rna = "";
        for (char dnaNucleobase : dna.toCharArray()) {
            if(dnaNucleobase=='T') {
                rna += 'U';
            } else {
                rna += dnaNucleobase;
            }
        }
        System.out.println(rna);
        assertThat(rna).isEqualTo("UUCCCCCAAUGGGGUGAAAGAUUACGGGGCCAAGUCUCAAUCGGCAUUUGGUUUUCGCUUGGAGCUUAACUGCAUCCAUGUCUGUACUUAUCCUGUUGUUCCUUGAGAGGACAAUCGUACGAUCACACCGGGGUUAGAAAAUUUUAUAAAGCAAGACAGAACAUACGUCACCAAACAACGAGACCAGUAUAGGGGCAAACGGUGAUAGUGUCGUAUUAUGAGUUCGAAGAGGGGCAAGGGGGAGAAGCGGUAAUGGUACCGAGUAAAAUCUUUUCAUGAAGAAACCUACUCCUUCUUAUGUCCUCUCAUGUAUCAUUCCACGGGAGGUGGCCGACGUUUCUGACUCAAUAACGGUACGCCUACAAAUUAGCCGGAGGUAGGACCCCGCGGAGCUGCUUCCCAGAUGACGACAUUCGCUGAUCCCCCUUAGCAUAUUUGACUGCAACUCGGGUGGUGUAUGGUUCCCCUAUCAGCUGACAAUAAUCAGACAGGAUGACACCACGAAACACUAAUAAUAAUAUCCGAGUCUAUAUCUUGGUUCCGGCAGCCGUCUAAGAGCUCUUUGACGAGACUGCAUACGGGCGAUCACGCUAUCGCUUAGAGUAGUUUUGUCGGAUUCAGACGUGAGCUGGCCUCGAUGAGUAGCUUGUUUAUGUAAGACGACUUAGGCAGCGCGUGUGCCGAAGCACGAUCUCACUGCACAAUAGUUAAGUAGAGAGUGGCUCUGGAGGGGCCCGGGUAGACAAGCUUAAGGUAUUGGUGUAUCUUUUCAACGGGUCCUAAUUCGUAUACUUGGCCAACUCACGUUUCCCGGGGCAUACACACCUUGAAAAGUUCACACUGCACGUAUGUCCUCAUACAUACAUCACGGCCUACAGCUUGCCAGUUGGCCGAGAUCGGGGAUGGCAAAUAAGGGAGAUAACGUCGCGAAGACGACUCCUCCUGUCACUCGCCCUGUCGCGAUAGGCAAACACG");
    }

    @Test
    public void shouldGiveReverseComplement() throws Exception {
        String dna = "GGCTGGAAGCATTGATTCCTCAACTCACACGGCCCTCATGTGCGCGCGAACTGTTTCGGAATAGGGATATAGGGGCCAATGATAGTTGTTTTCATAGACGATTCGTTAAGTCTATGCTCTAGGGTTGCATCAAGATCATTGAGCCGCTGCAGGTCGTTGGGAAATGTCAAACGGGAAAAGCGGTATCTATTTGTTGAGGGTCCGGCTTATACACTCACTACCCGGAACGTCGCGGTAATCATGAGAAGAACGTCGTAATGGCTCCGAATGGCATGCCTGCCCGCAGCTCTGGATCTAGAATGCGAACCAGATCGGCGAGTGTACAGCTTGGATAATCCCGACCTTGGGCTGGATACCTGGCCCACTTCATGGATCAACGCGATGCATCGTGGTCTTTTGAGGAATAGGCCCGCTGCATGCCTGAATAGTTAAGACAGTCGACCAGGCGTCGCAGCGGCTGGGTACTTCCAGTAGGTAAGAGTCTGAAATTTGACCCTCATTTTAATCAACACCTAGTGAGCCCTATGACCCTCGGAGCTTAGTTCGTGAAGCGACCGTAACCTGGACGTCAAGTTCCGGCCTCATTTAGTACGAAATTGATTAGTTTTCTAAGACCAGTTCTGGTTGATGTGGTAGCCATTAACTCCTGCTGAAAGTAGTAGTGAGTTGATAGTACCTCTCGGGAGTTGGCTGTGATCAGATCCCACATGTTCTTCACTATGGCGAATACGTCGGTCGCAGAGAATAGGGACGACTTGAGTCTTTGTATCGTAGTGACCACTAAAACATGATAGAAAATGACGTGAGCCAGACAGAGAGGCCAGTGGCCAAAGAAATGTCGCGCTTGGATAATAGTCC";

        String reverseComplement = "";
        char[] dnaBases = dna.toCharArray();
        for (int i = dnaBases.length-1; i>=0; i--) {
            reverseComplement += complement(dnaBases[i]);
        }

        System.out.println(reverseComplement);
        assertThat(reverseComplement).isEqualTo("GGACTATTATCCAAGCGCGACATTTCTTTGGCCACTGGCCTCTCTGTCTGGCTCACGTCATTTTCTATCATGTTTTAGTGGTCACTACGATACAAAGACTCAAGTCGTCCCTATTCTCTGCGACCGACGTATTCGCCATAGTGAAGAACATGTGGGATCTGATCACAGCCAACTCCCGAGAGGTACTATCAACTCACTACTACTTTCAGCAGGAGTTAATGGCTACCACATCAACCAGAACTGGTCTTAGAAAACTAATCAATTTCGTACTAAATGAGGCCGGAACTTGACGTCCAGGTTACGGTCGCTTCACGAACTAAGCTCCGAGGGTCATAGGGCTCACTAGGTGTTGATTAAAATGAGGGTCAAATTTCAGACTCTTACCTACTGGAAGTACCCAGCCGCTGCGACGCCTGGTCGACTGTCTTAACTATTCAGGCATGCAGCGGGCCTATTCCTCAAAAGACCACGATGCATCGCGTTGATCCATGAAGTGGGCCAGGTATCCAGCCCAAGGTCGGGATTATCCAAGCTGTACACTCGCCGATCTGGTTCGCATTCTAGATCCAGAGCTGCGGGCAGGCATGCCATTCGGAGCCATTACGACGTTCTTCTCATGATTACCGCGACGTTCCGGGTAGTGAGTGTATAAGCCGGACCCTCAACAAATAGATACCGCTTTTCCCGTTTGACATTTCCCAACGACCTGCAGCGGCTCAATGATCTTGATGCAACCCTAGAGCATAGACTTAACGAATCGTCTATGAAAACAACTATCATTGGCCCCTATATCCCTATTCCGAAACAGTTCGCGCGCACATGAGGGCCGTGTGAGTTGAGGAATCAATGCTTCCAGCC");
    }

    @Test
    public void shouldCalculateRabbits() throws Exception {
        int months=28;
        int reproductionRate=2;

        int numberOfPairs = getNumberOfPairs(months,reproductionRate);

        assertThat(numberOfPairs).isEqualTo(19);
    }

    private int getNumberOfPairs(int months, int reproductionRate) {
        if(months<=2) {
            return 1;
        } else {
            return getNumberOfPairs(months-2,reproductionRate)*reproductionRate + getNumberOfPairs(months-1,reproductionRate);
        }
    }

    private Character complement(char dnaBase) {
        Map<Character, Character> complements = new HashMap<Character, Character>() {{
            put('A', 'T');
            put('T', 'A');
            put('G', 'C');
            put('C', 'G');
        }};
        return complements.get(dnaBase);
    }

}
