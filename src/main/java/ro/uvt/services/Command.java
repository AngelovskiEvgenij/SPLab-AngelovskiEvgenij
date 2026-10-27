package ro.uvt.services;

public interface Command<T> {
    T execute(CommandContext context);
}