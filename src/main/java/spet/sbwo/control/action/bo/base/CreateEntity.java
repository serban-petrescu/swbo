package spet.sbwo.control.action.bo.base;

import spet.sbwo.control.action.base.BaseUserDatabaseAction;
import spet.sbwo.control.channel.base.JournalChannel;
import spet.sbwo.control.mapper.IMapper;
import spet.sbwo.data.access.IDatabaseExecutor;
import spet.sbwo.data.base.JournalizedBaseEntity;
import spet.sbwo.data.table.User;

import java.time.LocalDateTime;

public abstract class CreateEntity<T extends JournalizedBaseEntity, C extends JournalChannel>
    extends BaseUserDatabaseAction<C, T> {
    protected final Class<T> entity;

    protected CreateEntity(Class<T> entity, Class<C> channel) {
        super(channel, true);
        this.entity = entity;
    }

    @Override
    public T doRun(C input, IDatabaseExecutor executor, User user) {
        IMapper<T, C> mapper = mapper(executor);
        T t = mapper.toEntity(input);
        t.setCreatedBy(user);
        t.setCreatedOn(LocalDateTime.now());
        return t;
    }

    protected abstract IMapper<T, C> mapper(IDatabaseExecutor executor);

}
