package com.ippon.account.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.ippon.account.domain.Address_;
import com.ippon.account.service.AddressService;

public class AddressSearchForm implements Serializable {

  private static final long serialVersionUID = 1L;

  private String columnName;

  private String columnValue;

  @Inject
  @ApplicationScoped
  @Named("addressService")
  private transient AddressService addressService;

  // @Produces
  // AddressSearchForm foo(@Specializes @New AddressSearchForm
  // addressSearchForm) {
  // }

  //
  // @Produces
  // @A
  // public AddressService getAddressService(@New AddressService addressService)
  // {
  // this.addressService = addressService;
  // }

  @ModelAttribute("columnNames")
  public List<SelectColumn> getColumnNames() {
    List<SelectColumn> allColumnNames = new ArrayList<SelectColumn>();
    for (int i = 0; i < Address_.class.getDeclaredFields().length; i++) {
      String columnValue = (Address_.class.getDeclaredFields()[i]).getName();
      allColumnNames.add(new SelectColumn(addressService.getMessage("editAccount.field.account.address." + columnValue, null, Locale.getDefault()), columnValue));
    }
    return allColumnNames;
  }

  @ModelAttribute("columnName")
  public String getColumnName() {
    return columnName;
  }

  public void setColumnName(String columnName) {
    this.columnName = columnName;
  }

  @ModelAttribute("columnValue")
  public String getColumnValue() {
    return columnValue;
  }

  public void setColumnValue(String columnValue) {
    this.columnValue = columnValue;
  }

  private class SelectColumn implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String columnLabel;

    private String columnValue;

    SelectColumn(String columnLabel, String columnValue) {
      this.columnLabel = columnLabel;
      this.columnValue = columnValue;
    }

    public String getColumnLabel() {
      return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
      this.columnLabel = columnLabel;
    }

    public String getColumnValue() {
      return columnValue;
    }

    public void setColumnValue(String columnValue) {
      this.columnValue = columnValue;
    }

  }
}
