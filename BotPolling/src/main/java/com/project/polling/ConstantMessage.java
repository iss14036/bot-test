package com.project.polling;

public class ConstantMessage {
	public static final String POLLING = "polling";
	public static final String POLLING_CREATE = "polling_create";
	public static final String POLLING_OFF = "polling_off";
	public static final String REQUEST_POLLING = "Apakah andah ingin membuat Polling?";
	public static final String AMBIGUOUS_MESSAGE = "masukan anda kurang jelas, mohon diperiksa lagi ^_^";
	public static final String INPUT_NAMA_POLLING = "Masukkan nama polling\n\n"
			+ "ex : Polling Baju Lebaran\n"
			+ "Jika anda ingin membatalkan, ketik 'cancel'";
	public static final String INPUT_OPTION_POLLING = "Masukkan nama-nama opsi polling\n\n"
			+ "ex : kemeja,kaos,baju renang\n"
			+ "Jika anda ingin membatalkan, ketik 'cancel'";
	public static final String OPTION_GUIDE = "Silahkan pilih berdasarkan angka yang tersedia.\n" + "ex : 1\n"
			+ "Karakter selain angka diatas tidak akan dimasukkan.\n";
	public static final String UNMATCHED_AUTHOR = "Anda bukan author dari polling ini\n"
			+ "Jadi, polling tersebut tidak dapat dimatikan.";
	public static final String WARN_POLLING_ACTIVE = "Masih ada polling yang hidup. Jika ingin membuat polling baru,\n"
			+ "Silahkan matikan polling yang hidup, dengan cara 'polling_off'";
	public static final String TURN_OFF_POLLING = "Polling dimatikan, jika ingin membuat polling tekan 'polling_create'";
	public static final String HELP = "Polling Bot Guide :\n" + "1. Membuat Polling : 'polling_create'\n"
			+ "2. Melihat option Polling : 'polling_show'\n" + "3. Mematikan Polling : 'polling_off'\n"
			+ "4. Melihat hasil Polling : 'polling_result'\n";
	public static final String COMPLETED_INSERTION = "Masukan anda berhasil disimpan";
	public static final String CANCELED_INSERTION = "Anda sudah memilih, Sehingga tidak diijinkan lagi";
	public static final String VALIDATION_WARN = "Anda tidak berhak! karena anda bukan author.";
	public static final String CANCEL = "cancel";
	public static final String VAPO = "VAPO";
	public static final String VAPO_REAL = "Virtual Assistant Polling";
	public static final String EMPTY_POLLING = "Tidak ada polling yang berjalan.";
	public static final String CANCEL_POLLING = "Pembuatan polling dibatalkan";
}
