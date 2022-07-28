CREATE TABLE IF NOT EXISTS LISTA_JOGADORES (
	id bigint not null auto_increment,
    nome varchar(60) not null,
    jogador_id bigint not null,
    
    primary key (id),
    foreign key (jogador_id) references jogadores(id)
);