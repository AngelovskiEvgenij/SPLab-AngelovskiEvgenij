package ro.uvt.services;

public class DeleteBookCommand implements Command<Boolean> {
    private final int id;

    public DeleteBookCommand(int id) {
        this.id = id;
    }

    @Override
    public Boolean execute(CommandContext context) {
        if (!context.getBooksRepository().existsById(id)) {
            return false;
        }
        context.getBooksRepository().deleteById(id);
        return true;
    }
}