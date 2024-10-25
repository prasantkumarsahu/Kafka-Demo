package com.prasant.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Prasant
 * Date: 25/10/24
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private int id;
	private String firstName;
	private String lastName;
}
