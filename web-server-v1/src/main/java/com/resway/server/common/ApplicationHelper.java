/*
 * Copyright (©) Residential Way, 2016 - 2017, All rights reserved. The
 * intellectual and technical concepts contained herein are proprietary to
 * Residential Way and its suppliers and may be covered by U.S. and Foreign
 * Patents, patents in process, and are protected by trade secret or copyright
 * law. Unauthorized copying of this file, via any medium is strictly
 * prohibited. Proprietary and confidential.
 */
package com.resway.server.common;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.resway.server.entity.domain.SampleArticle;

/**
 * This class is to be used as a helper that provides access to all common
 * methods and conversions required to perform basic operations.
 *
 * @author Kevin
 * @since 1.0.0
 */
public class ApplicationHelper {
	/**
	 * Merges the orginal object with the updated object by skipping the
	 * attributes with <i>null</i> values.
	 *
	 * @param src
	 *            {@link Object} updated object.
	 * @param target
	 *            {@link Object} original object. {@link SampleArticle} object
	 *            requested with updated fields.
	 */
	public static void copyNonNullProperties(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	/**
	 * Returns an array of fields that have attributes with <i>null</i> value in
	 * the desired object.
	 *
	 * @param source
	 *            {@link Object} updated object.
	 * @return {@link String} array of fields that have attributes with
	 *         <i>null</i> value in the desired object.
	 */
	private static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null) {
				emptyNames.add(pd.getName());
			}
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}
}
