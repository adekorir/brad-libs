package brad.data;

public interface BeanBuilder<T extends Bean> {
    T build();
}
