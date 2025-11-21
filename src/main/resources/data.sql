INSERT INTO competencias (id, nome, categoria, descricao) VALUES
(1,'Analise de Dados','Tecnologia','Fundamentos de analise de dados'),
(2,'Machine Learning','Tecnologia','Conceitos de ML'),
(3,'Empatia','Humana','Habilidades socioemocionais'),
(4,'Colaboracao','Humana','Trabalho em equipe'),
(5,'Green Tech','Tecnologia','Tecnologias sustentaveis');

INSERT INTO trilhas (id, nome, descricao, nivel, carga_horaria, foco_principal) VALUES
(1,'Data Basics','Introdução a dados','INICIANTE',40,'Dados'),
(2,'AI Foundations','Fundamentos de IA','INTERMEDIARIO',80,'IA'),
(3,'Soft Skills Essentials','Comunicação e empatia','INICIANTE',20,'Soft Skills');

INSERT INTO usuarios (id, nome, email, area_atuacao, nivel_carreira, data_cadastro) VALUES
(1,'Ana Silva','ana@ex.com','TI','Em transição','2025-10-01'),
(2,'Bruno Santos','bruno@ex.com','Marketing','Pleno','2025-10-05'),
(3,'Carla Pereira','carla@ex.com','RH','Junior','2025-09-20');

INSERT INTO trilha_competencia (trilha_id, competencia_id) VALUES
(1,1),(1,4),(2,2),(2,1),(3,3);

INSERT INTO matriculas (id, usuario_id, trilha_id, data_inscricao, status) VALUES
(1,1,1,'2025-11-01','ATIVA'),
(2,2,2,'2025-11-03','ATIVA');
