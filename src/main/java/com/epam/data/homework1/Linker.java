package com.epam.data.homework1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Linker {

    private static Map<BytesContainer, Path> content = new HashMap<>();

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            link(new File(args[0]));
        } else {
            System.exit(-1);
        }
    }

    private static void link(File file) throws IOException {
        if (!file.isDirectory()) {
            createLinkIfDuplicate(file);
        } else {
            for (File innerFile : file.listFiles()) {
                link(innerFile);
            }
        }
    }

    private static void createLinkIfDuplicate(File file) throws IOException {
        Path path = Paths.get(file.toURI());

        byte[] bytes = Files.readAllBytes(path);
        BytesContainer bytesContainer = new BytesContainer(bytes);

        Path existingPath = content.get(bytesContainer);
        if (existingPath != null) {
            Files.delete(path);
            Files.createLink(path, existingPath);
        } else {
            content.put(bytesContainer, path);
        }
    }

    private static class BytesContainer {

        private byte[] bytes;

        BytesContainer(byte[] bytes) {
            this.bytes = bytes;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BytesContainer that = (BytesContainer) o;
            return Arrays.equals(bytes, that.bytes);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(bytes);
        }
    }
}
