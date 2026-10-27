package ro.uvt.services;

import java.util.List;

public record BookRequest(String title, List<String> authors) {
}