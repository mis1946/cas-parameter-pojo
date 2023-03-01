/**
 * @author  Michael Cuison
 */
package org.rmj.cas.parameter.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.rmj.appdriver.constants.RecordStatus;
import org.rmj.appdriver.iface.GEntity;

@Entity
@Table(name="Banks")

public class UnitBank implements Serializable, GEntity {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "sBankCode")
    private String sBankCode;
    
    @Column(name = "sBankName")
    private String sBankName;
    
    @Column(name = "cRecdStat")
    private String cRecdStat;
    
    @Column(name = "sModified")
    private String sModified;
    
    @Basic(optional = false)
    @Column(name = "dModified")
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dModified;

    LinkedList laColumns = null;
    
    public UnitBank(){
        this.sBankCode = "";
        this.sBankName = "";
        this.cRecdStat = RecordStatus.ACTIVE;
        
        laColumns = new LinkedList();
        laColumns.add("sBankCode");
        laColumns.add("sBankName");
        laColumns.add("cRecdStat");
        laColumns.add("sModified");
        laColumns.add("dModified");
    }
    
    public void setBankCode(String sBankCode){
        this.sBankCode = sBankCode;
    }
    public String getBankCode(){
        return sBankCode;
    }
    
    public void setBankName(String sBankName){
        this.sBankName = sBankName;
    }
    public String getBankName(){
        return sBankName;
    }
    
    public void setRecordStat(String cRecdStat){
        this.cRecdStat = cRecdStat;
    }
    public String getRecordStat(){
        return cRecdStat;
    }
    
    public void setModifiedBy(String sModified){
        this.sModified = sModified;
    }
    public String getModifiedBy(){
        return sModified;
    }
    
    public void setDateModified(Date dModified){
        this.dModified = dModified;
    }
    public Date getDateModified(){
        return dModified;
    }
    
    @Override
    public int hashCode(){
        int hash = 0;
        hash += (sBankCode != null ? sBankCode.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnitBank)) {
            return false;
        }
        UnitBank other = (UnitBank) object;
        if ((this.sBankCode == null && other.sBankCode != null) || (this.sBankCode != null && !this.sBankCode.equals(other.sBankCode))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "org.rmj.parameter.pojo.UnitBank[sBankCode=" + sBankCode + "]";
    }
    
    @Override
    public Object getValue(int fnColumn) {
        switch(fnColumn){
            case 1: return sBankCode;
            case 2: return sBankName;
            case 3: return cRecdStat;
            case 4: return sModified;
            case 5: return dModified;
            default: return null;
        }
    }

    @Override
    public Object getValue(String fsColumn) {
        int lnCol = getColumn(fsColumn);
        
        if (lnCol > 0){
            return getValue(lnCol);
        } else
            return null;
    }

    @Override
    public String getTable() {
        return "Banks";
    }

    @Override
    public String getColumn(int fnCol) {
        if (laColumns.size() < fnCol){
            return "";
        } else 
            return (String) laColumns.get(fnCol - 1);
    }

    @Override
    public int getColumn(String fsCol) {
        return laColumns.indexOf(fsCol) + 1;
    }

    @Override
    public void setValue(int fnColumn, Object foValue) {
        switch(fnColumn){
            case 1:
                sBankCode = (String) foValue;
                break;
            case 2:
                sBankName = (String) foValue;
                break;
            case 3:
                cRecdStat = (String) foValue;
                break;
            case 4:
                sModified = (String) foValue;
                break;
            case 5:
                dModified = (Date) foValue;
                break;
        }    
    }

    @Override
    public void setValue(String fsColumn, Object foValue) {
        int lnCol = getColumn(fsColumn);
        if (lnCol > 0){
            setValue(lnCol, foValue);
        }
    }

    @Override
    public int getColumnCount() {
        return laColumns.size();
    }

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
