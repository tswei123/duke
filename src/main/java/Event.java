public class Event extends Todo {
    protected String eventTime;
    
    public Event(String description, String eventTime) {
        super(description);
        setEvent(eventTime);
    }
    public void setDone(){
        this.isDone = true;
        System.out.println("\tNice! I've marked this task as done:\n" +
                "\t  [E][X] " + description + "(at: " + eventTime + ")");
    }
    public void print(){
        if (isDone) {
            System.out.println("\t  [E][X] " + description + "(at: " + eventTime + ")");
        }
        else {
            System.out.println("\t  [E][ ] " + description + "(at: " + eventTime + ")");
        }

    }
    public void setEvent(String eventTime)
    {
        this.eventTime = eventTime;
    }
    @Override
    public String toString() {
        String box = "[E][ ] ";
        if (isDone){
            box = "[E][X] ";
        }
        return (box + description + "(at: " + eventTime + ")");
    }
}
