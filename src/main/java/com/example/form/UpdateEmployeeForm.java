package com.example.form;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

/**
 * 従業員情報更新時に使用するフォーム.
 * 
 * @author igamasayuki
 * 
 */
public class UpdateEmployeeForm {
	/** id */
	private String id;
	/** 扶養人数 */
	@Pattern(regexp = "^[0-9]+$", message = "扶養人数は数値で入力してください")
	private String dependentsCount;

	//input type="text"にしたらあああともはいる。入力値チェックをするならIntegerとかでよかった・・・

	@NotEmpty(message="名前を入力してください")
	@Length(min=1,max=20,message="名前は20文字以下で入力してください")
	private String name;
    @NotEmpty(message="性別を入力してください")
	private String gender;
	@NotEmpty(message="入社日を入力してください")
	private String hireDate;
	@Email(message ="メールアドレスの形式が不正です" )
	@Length(min=1,max=50,message = "メールアドレスは50文字以下で入力してください")
	private String mailAddress;
	@Pattern(regexp="^[0-9]{3}-[0-9]{4}$" , message="郵便番号を入力してください")
	private String zipCode;
	@Length(max=100,message="住所は最大100文字で入力してください")
	private String address;
	@Pattern(regexp =  "^0\\d{1,4}-\\d{1,4}-\\d{4}$", message = "電話番号は「-」含めて最大13文字で入力してください")
	private String telephone;
	@Pattern(regexp = "^[0-9]+$", message = "給料は数値で入力してください")
	@NotEmpty(message = "給料を入力してください")
	private String salary;
	@NotEmpty(message="特性を入力してください")
	@Length(max=500,message="特性は最大500文字で入力してください")
	private String characteristics;

	/**
	 * IDを数値として返します.
	 * 
	 * @return 数値のID
	 */
	public Integer getIntId() {
		return Integer.parseInt(id);
	}

	/**
	 * 扶養人数を数値として返します.
	 * 
	 * @return 数値の扶養人数
	 */

	 public Integer getIntDependentsCount() {
		return Integer.parseInt(dependentsCount);
	}

	public Date getHireDateAsDate() {
        if (hireDate != null && !hireDate.isEmpty()) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // 日付のフォーマットに合わせる
                return formatter.parse(hireDate); // StringをDateに変換
            } catch (ParseException e) {
                e.printStackTrace(); // 例外が発生した場合はスタックトレースを表示
            }
        }
        return null; // 変換できなかった場合はnullを返す
    }

	
   
		
    public Integer getIntZipCode(){
		return Integer.parseInt(zipCode);
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getIntTelephone(){
		return Integer.parseInt(telephone);
	}


	public Integer getIntSalary(){
		return Integer.parseInt(salary);
	}

	
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDependentsCount() {
		return dependentsCount;
	}


	public void setDependentsCount(String dependentsCount) {
		this.dependentsCount = dependentsCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

	

	@Override
	public String toString() {
		return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + ", name=" + name + ", gender="
				+ gender + ", hireDate=" + hireDate + ", mailAddress=" + mailAddress + ", zipCode=" + zipCode
				+ ", address=" + address + ", telephone=" + telephone + ", salary=" + salary + ", characteristics="
				+ characteristics + "]";
	}




	
	
	

   

}
