package hilos;

import vista.FrmMenuPrincipal;

public class HiloTiempo extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			FrmMenuPrincipal.crearConectadosJlabel();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
