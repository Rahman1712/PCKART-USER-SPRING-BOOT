package com.ar.pckart.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor 
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "user_id")
	private User user;
	
	@Lob
	@Column(name = "profile_pic",length=100000)
	private byte[] profile_image;

	@Lob
	@Column(name = "address1", length = 512)
	private String address1; 
	
	@Lob
	@Column(name = "address2", length = 512)
	private String address2;
	
}
