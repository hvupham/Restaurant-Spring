package com.tananh.modal;

import java.io.Serializable;
import java.util.Objects;

public class CTHDId implements Serializable {

    private Long idHoaDon;

    private Long idMonAn;

    public CTHDId() {
    }
    
    public CTHDId(Long idHoaDon, Long idMonAn) {
		super();
		this.idHoaDon = idHoaDon;
		this.idMonAn = idMonAn;
	}
    
	// Constructors, getters and setters...
    
    public Long getIdHoaDon() {
		return idHoaDon;
	}

	public void setIdHoaDon(Long idHoaDon) {
		this.idHoaDon = idHoaDon;
	}

	public Long getIdMonAn() {
		return idMonAn;
	}

	public void setIdMonAn(Long idMonAn) {
		this.idMonAn = idMonAn;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CTHDId)) return false;
        CTHDId that = (CTHDId) o;
        return Objects.equals(getIdHoaDon(), that.getIdHoaDon()) && 
               Objects.equals(getIdMonAn(), that.getIdMonAn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdHoaDon(), getIdMonAn());
    }
}

