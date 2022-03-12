package com.example.demo.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity // このクラスをEntityとして使うためのアノテーション
@Data
public class User {
	@Id // userテーブルのプライマリーキーidに付けるアノテーション
	 @GeneratedValue(strategy = GenerationType.IDENTITY) // idがMySQLのauto_incrementの場合、自動生成させるためにアノテーションを付ける

 private Long id;

 private String name;

 private String email;

}