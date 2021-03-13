package com.cust_trial.journal.periodplanning.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "LESSION")
public class Lession {

  @Id
  @Column(name = "LESSIONID", nullable = false)
  private String lessionId;

  @Column(name = "LESSIONNAME", nullable = false)
  private String lessionName;

  public String getLessionId() {
    return lessionId;
  }

  public void setLessionId(String lessionId) {
    this.lessionId = lessionId;
  }

  public String getLessionName() {
    return lessionName;
  }

  public void setLessionName(String lessionName) {
    this.lessionName = lessionName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Lession lession = (Lession) o;
    return lessionId.equals(lession.lessionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lessionId);
  }

  @Override
  public String toString() {
    return "Lession{" +
            "lessionId='" + lessionId + '\'' +
            ", lessionName='" + lessionName + '\'' +
            '}';
  }
}
