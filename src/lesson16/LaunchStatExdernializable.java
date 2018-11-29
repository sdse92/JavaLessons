package lesson16;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatExdernializable implements Externalizable{

    private int launchCount;
    private Date lastLaunch;

    private static final long serialVersionUID = 0L;
    private static final int VERSION = 0;

    public boolean isFirstLaunch(){
        return launchCount == 0 && lastLaunch == null;
    }

    public void update(){
        launchCount++;
        lastLaunch = new Date();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeInt(launchCount);
        out.writeObject(lastLaunch);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version > VERSION){
            throw new IOException("unsupported version");
        }

        launchCount = in.readInt();
        lastLaunch = (Date) in.readObject();
    }

    @Override
    public String toString() {
        return "LaunchStatExdernializable{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                '}';
    }
}
