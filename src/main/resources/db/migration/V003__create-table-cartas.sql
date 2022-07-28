CREATE TABLE IF NOT EXISTS CARTAS (
	id bigint not null auto_increment,
    nome varchar(60) not null,
    edicao varchar(60) not null,
    idioma varchar(30) not null,
    laminada tinyint(1) not null,
    valor decimal(6,2),
    quantidade int,
    lista_jogador_id bigint not null,
    
    primary key(id),
    foreign key(lista_jogador_id) references lista_jogadores(id)
)