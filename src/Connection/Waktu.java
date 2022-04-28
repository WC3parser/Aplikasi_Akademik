/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

/**
 *
 * @author USER
 */
import java.util.*;
public class Waktu {
    public Waktu(){};
private Calendar calendar = Calendar.getInstance();

//public String getHari() {

//if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
//return "Minggu";
//} else if (calendar.get(Calendar.DAY_OF_WEEK) == 2) {
//return "Senin";
//} else if (calendar.get(Calendar.DAY_OF_WEEK) == 3) {
//return "Selasa";
//} else if (calendar.get(Calendar.DAY_OF_WEEK) == 4) {
//return "Rabu";
//} else if (calendar.get(Calendar.DAY_OF_WEEK) == 5) {
//return "Kamis";
//} else if (calendar.get(Calendar.DAY_OF_WEEK) == 6) {
//return "Jumat";
//} else {
//return "Sabtu";
//}
//}

//public String getBulan() {

//if (calendar.get(Calendar.MONTH) == 0) {
//return "Januari";
//} else if (calendar.get(Calendar.MONTH) == 1) {
//return "Februari;
//} else if (calendar.get(Calendar.MONTH) == 2) {
//return "Maret";
//} else if (calendar.get(Calendar.MONTH) == 3) {
//return "April";
//} else if (calendar.get(Calendar.MONTH) == 4) {
//return "Mei";
//} else if (calendar.get(Calendar.MONTH) == 5) {
//return "Juni";
//} else if (calendar.get(Calendar.MONTH) == 6) {
//return "Juli";
//} else if (calendar.get(Calendar.MONTH) == 7) {
//return "Agustus";
//} else if (calendar.get(Calendar.MONTH) == 8) {
//return "September";
//} else if (calendar.get(Calendar.MONTH) == 9) {
//return "Oktober";
//} else if (calendar.get(Calendar.MONTH) == 10) {
//return "November"
//} else {
//return "Desember";
//}
//}

public String getWaktu() {

String hari;
String tanggal;
String bulan;
String tahun;
//hari = getHari();
tanggal = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
bulan = String.valueOf(calendar.get(Calendar.MONTH));
int bln = Integer.parseInt(bulan);
int bul = bln+1;
tahun = String.valueOf(calendar.get(Calendar.YEAR));
//return (hari + ", " + tanggal + " " + bulan + " " + tahun);
return (tanggal + "-" + bul + "-" + tahun);

}

}

