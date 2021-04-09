package org.corso.banca;

public class Banca {

    private static int prossimoNumeroContoCorrente = 1;
    private static int indiceContiCorrenti = 0;
    private ContoCorrente[] contiCorrenti;

    public Banca() {
        contiCorrenti = new ContoCorrente[10];
    }

    public void apriContoCorrente(String nome, String cognome, String codiceFiscale, int valoreIniziale) {
        Cliente proprietario = new Cliente(nome, cognome, codiceFiscale);
        ContoCorrente conto = new ContoCorrente("" + prossimoNumeroContoCorrente, 1000, valoreIniziale, proprietario);
        contiCorrenti[indiceContiCorrenti++] = conto;
        prossimoNumeroContoCorrente++;
    }

    public void operaPrelievo(int importo, String nContoCorrente) {
        for (int i = 0; i < contiCorrenti.length - 1; i++) {
            if (contiCorrenti[i].getnContoCorrente().equals(nContoCorrente)) {
                try {
                    contiCorrenti[i].prelievo(importo);
                } catch (MancanzaFondiException e) {
                    // TODO Auto-generated catch block
                    System.err.println(e.getMessage());
                }
                break;
            }
        }
    }

    public void operaPrelievoPerCodiceFiscale(int importo, String codiceFiscale) {
        for (int i = 0; i < contiCorrenti.length - 1; i++)
            if (contiCorrenti[i].getProprietario().getCodiceFiscale().equals(codiceFiscale)) {
                try {
                    contiCorrenti[i].prelievo(importo);
                } catch (MancanzaFondiException e) {
                    // TODO Auto-generated catch block
                    System.err.println(e.getMessage());
                }
                break;
            }

    }

    public void operaVersamentoPerCodiceFiscale(int importo, String codiceFiscale) {
        for (int i = 0; i < contiCorrenti.length - 1; i++)
            if (contiCorrenti[i].getProprietario().getCodiceFiscale().equals(codiceFiscale)) {
                contiCorrenti[i].versamento(importo);
                break;

            }
    }

    public void operaVersamento(int importo, String nContoCorrente) {
        for (int i = 0; i < contiCorrenti.length - 1; i++) {
            if (contiCorrenti[i].getnContoCorrente().equals(nContoCorrente)) {
                contiCorrenti[i].versamento(importo);
                break;
            }
        }
    }
    //commento di prova
    public ContoCorrente[] getContiCorrenti() {
        return contiCorrenti;
    }

}