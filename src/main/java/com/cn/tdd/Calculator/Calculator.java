package com.cn.tdd.Calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
	public final static int calculate(List<String> instructions) {
		int sum = 0;
		if (instructions.size() == 0) {
			throw new RuntimeException("Exception, empty instructions");
		} else {
			if (!instructions.get(instructions.size() - 1).contains("apply")) {
				throw new RuntimeException("apply instruction not found");

			} else {
				String instructionLine[] = instructions.get(
						instructions.size() - 1).split(" ");

				if (!instructionLine[instructionLine.length - 1]
						.matches("-?\\d+(\\.\\d+)?")) {
					throw new RuntimeException(
							"apply instruction must be with number");
				} else {
					int applyNumber = Integer
							.parseInt(instructionLine[instructionLine.length - 1]);
					for (String s : instructions) {
						String instructionLine2[] = s.split(" ");
						sum += Integer
								.parseInt(instructionLine2[instructionLine2.length - 1]);
					}
					return sum;
				}

			}
		}
	}

	public static List<String> readFile(String path) {
		BufferedReader br = null;
		List<String> lines = new ArrayList<String>();

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(path));

			while ((sCurrentLine = br.readLine()) != null) {
				lines.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return lines;
		}
	}
}
