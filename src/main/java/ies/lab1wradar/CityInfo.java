package ies.lab1wradar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityInfo {
	
	@SerializedName("idRegiao")
    @Expose
    private Integer idRegiao;
	@SerializedName("idAreaAviso")
    @Expose
    private String idAreaAviso;
	@SerializedName("idConcelho")
    @Expose
    private Integer idConcelho;
	@SerializedName("globalIdLocal")
    @Expose
    private Integer globalIdLocal;
	@SerializedName("latitude")
    @Expose
    private String latitude;
	@SerializedName("idDistrito")
    @Expose
    private Integer idDistrito;
	@SerializedName("local")
    @Expose
    private String local;
	@SerializedName("longitude")
    @Expose
    private String longitude;
	
	public Integer getIdRegiao() {
		return idRegiao;
	}
	public String getIdAreaAviso() {
		return idAreaAviso;
	}
	public Integer getIdConcelho() {
		return idConcelho;
	}
	public Integer getGlobalIdLocal() {
		return globalIdLocal;
	}
	public String getLatitude() {
		return latitude;
	}
	public Integer getIdDistrito() {
		return idDistrito;
	}
	public String getLocal() {
		return local;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setIdRegiao(Integer idRegiao) {
		this.idRegiao = idRegiao;
	}
	public void setIdAreaAviso(String idAreaAviso) {
		this.idAreaAviso = idAreaAviso;
	}
	public void setIdConcelho(Integer idConcelho) {
		this.idConcelho = idConcelho;
	}
	public void setGlobalIdLocal(Integer globalIdLocal) {
		this.globalIdLocal = globalIdLocal;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
