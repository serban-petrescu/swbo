package spet.sbwo.control.action.user;

import spet.sbwo.control.action.base.BaseUserDatabaseAction;
import spet.sbwo.control.channel.user.UserChannel;
import spet.sbwo.control.channel.user.UserInfoChannel;
import spet.sbwo.data.access.IDatabaseExecutor;
import spet.sbwo.data.table.User;
import spet.sbwo.data.view.UserPlain;

import java.util.stream.Collectors;

public class ReadCurrentUserInfo extends BaseUserDatabaseAction<Void, UserInfoChannel> {

    public ReadCurrentUserInfo() {
        super(UserInfoChannel.class, true);
    }

    @Override
    public UserInfoChannel doRun(Void input, IDatabaseExecutor executor, User user) {
        UserInfoChannel result = new UserInfoChannel();
        result.setId(user.getId());
        result.setUsername(user.getUsername());
        result.setPreference(new ReadPreference().run(input, executor, user));
        result.setOthers(new ReadAllUserPlains().run(input, executor).stream()
            .filter(u -> !user.getUsername().equals(u.getUsername())).map(this::mapPlainToChannel)
            .collect(Collectors.toList()));
        return result;
    }

    protected UserChannel mapPlainToChannel(UserPlain plain) {
        UserChannel channel = new UserChannel();
        channel.setId(plain.getId());
        channel.setActive(plain.isActive());
        channel.setUsername(plain.getUsername());
        return channel;
    }

}
