package ctn.stonecraft.non_game_files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static ctn.stonecraft.StoneCraft.SC_ID;

/// 简易图片文件生成器
public class FileGenerator {
	private final String modId;
	
	public FileGenerator(String modId) {
		this.modId = modId;
	}
	
	public static void main(String[] args) {
		FileGenerator generator = new FileGenerator(SC_ID);
		generator.generate();
	}
	
	// 在这生成
	public void generate() {
	
	}
	
	public void generateFiles(String name) {
		generateFiles(name, 5);
	}
	
	public void generateFiles(String name, int count) {
		for (int i = 1; i <= count; i++) {
			generateFile("src/main/resources/assets/" + modId + "/textures/block/" + name, "v" + i);
		}
	}
	
	/**
	 * 在指定路径生成一个文件，并写入指定内容
	 *
	 * @param directoryPath 文件所在目录路径（如："D:/程序/项目/StoneCraft/assets/stonecraft/models/block"）
	 * @param fileName      文件名（如："compressed_cobblestone.json"）
	 */
	public void generateFile(String directoryPath, String fileName) {
		Path dirPath = Paths.get(directoryPath);
		Path filePath = dirPath.resolve(fileName + ".png");
		
		try {
			// 创建目录（如果不存在）
			if (!Files.exists(dirPath)) {
				Files.createDirectories(dirPath);
			}
			
			// 如果文件存在且不允许覆盖，则跳过
			if (Files.exists(filePath)) {
				System.out.println("The file already exists, skip writing: " + filePath);
				return;
			}
			
			// 写入内容
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
				writer.write("");
			}
			
			System.out.println("Successfully generated file: " + filePath);
			
		} catch (IOException e) {
			System.err.println("Failed to generate file: " + filePath);
			e.printStackTrace();
		}
	}
}
