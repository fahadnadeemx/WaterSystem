package com.axcore.portal.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axcore.portal.entity.Admin;
import com.axcore.portal.repository.AdminRepository;

@Service
public class AdminServiceImpl {
	@Autowired
	private  AdminRepository adminRepository;


	public Admin findByUsername(String username) {
		return adminRepository.findByUsername(username);
	}

	  public boolean authenticate(String username, String password) {
	        // Retrieve admin from database by username
	        Admin admin = adminRepository.findByUsername(username);
	        if (admin != null) {
	            // Check if the password matches (assuming password is stored in MD5 format)
	            String hashedPassword = hashPassword(password); // Convert plain text password to MD5
	            return hashedPassword.equals(admin.getPassword());
	        }
	        return false;
	    }

	    private String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] digest = md.digest(password.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : digest) {
	                sb.append(String.format("%02x", b));
	            }
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
