package champollion;

public class ServicePrevu {
	// TODO : implémenter cette classe
    protected int volumeCM;
    protected int volumeTD;
    protected int volumeTP;
    protected UE UE;

    public ServicePrevu(int volumeCM, int volumeTD, int volumeTP, UE UE) {
        this.volumeCM = volumeCM;
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.UE = UE;
    }
    
    

    public UE getUE() {
        return UE;
    }

    public void setUE(UE UE) {
        this.UE = UE;
    }

   
    public int getVolumeCM() {
        return volumeCM;
    }

    public void setVolumeCM(int volumeCM) {
        this.volumeCM = volumeCM;
    }

    public int getVolumeTD() {
        return volumeTD;
    }

    public void setVolumeTD(int volumeTD) {
        this.volumeTD = volumeTD;
    }

    public int getVolumeTP() {
        return volumeTP;
    }

    public void setVolumeTP(int volumeTP) {
        this.volumeTP = volumeTP;
    }

    @Override
    public String toString() {
        return "ServicePrevu{" + "volumeCM=" + volumeCM + ", volumeTD=" + volumeTD + ", volumeTP=" + volumeTP + '}';
    }
    
    

}
