package pl.rafalszyszka.cvapp.model.sections;

import java.util.ArrayList;
import java.util.Date;

import pl.rafalszyszka.cvapp.model.Certificate;

/**
 * Created by Squier on 2016-07-02.
 */
public class CertificatesSec {

    private ArrayList<Certificate> certificates;

    /**
     * Creates certificates section
     *
     * @param certificates array for certificates
     */
    public CertificatesSec(ArrayList<Certificate> certificates) {
        this.certificates = certificates;
    }

    /**
     * Add certificate to certificates section
     *
     * @param certificate certificate's description
     */
    public void addCertificate(Certificate certificate) {
        certificates.add(certificate);
    }

    /**
     * Add certificate to certificates section
     *
     * @param date        when certificate was earned
     * @param description few words about certificate
     */
    public void addCertificate(Date date, String description) {
        certificates.add(new Certificate(date, description));
    }

    /**
     * Return certificate's description by given index
     *
     * @param index index of certificate
     * @return certificate description
     */
    public Certificate getCertificateByIndex(int index) {
        return certificates.get(index);
    }

    public ArrayList<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(ArrayList<Certificate> certificates) {
        this.certificates = certificates;
    }
}
