# 📱 WeekTech 2026

Sistema mobile desenvolvido em Android Studio para gerenciamento do evento **WeekTech 2026**, permitindo visualizar eventos, realizar inscrições, participar de palestras e gerenciamento administrativo.

---

# ✨ Funcionalidades

## 👤 Usuário

- Visualizar eventos cadastrados
- Ver detalhes dos eventos
- Realizar inscrição em eventos
- Participar do Coffee Break
- Visualizar palestras
- Consultar FAQ
- Visualizar localização do evento no Google Maps

---

## 🛠️ Administrador

- Cadastrar eventos
- Visualizar quantidade de inscritos
- Gerenciar palestras
- Gerenciar participantes
- Painel administrativo responsivo

---

# 📸 Interface

O sistema possui:

- Layout moderno
- Tema escuro
- Responsividade para dispositivos Android
- Compatibilidade com notch/câmera frontal
- Cards interativos
- Navegação simplificada

---

# 🧱 Tecnologias Utilizadas

| Tecnologia | Uso |
|---|---|
| Java | Desenvolvimento Android |
| XML | Interfaces |
| Room Database | Banco de dados local |
| Material Design | Componentes visuais |
| Android Studio | IDE principal |

---

# 📂 Estrutura do Projeto

```bash
com.gabriel.weektech
│
├── activities
│   ├── MainActivity
│   ├── EventoActivity
│   ├── AdminActivity
│   ├── FAQActivity
│   ├── LocalizacaoActivity
│   └── InscricaoActivity
│
├── adapters
│   └── EventoAdapter
│
├── database
│   └── AppDatabase
│
├── models
│   ├── Evento
│   ├── Inscricao
│   ├── Palestra
│   ├── Usuario
│   └── Localizacao
│
└── models.dao
    ├── EventoDao
    ├── InscricaoDao
    └── PalestraDao
```

---

# 🗄️ Banco de Dados

O projeto utiliza o **Room Database** para armazenamento local.

## Entidades principais

### Evento
- Nome
- Descrição
- Data
- Vagas
- Quantidade de inscritos

### Inscrição
- Evento
- Usuário
- Coffee Break
- Presença confirmada

### Palestra
- Nome
- Descrição
- Horário

---

# 🚀 Como Executar

## 1️⃣ Clonar o projeto

```bash
https://github.com/GabrielVancoDev/weektech.app/

```

---

## 2️⃣ Abrir no Android Studio

- Abra o Android Studio
- Clique em:
  - `Open Project`
- Selecione a pasta do projeto

---

## 3️⃣ Sincronizar Gradle

O Android Studio irá baixar automaticamente:

- Dependências
- Bibliotecas
- Room Database
- Material Components

---

## 4️⃣ Executar

- Conecte um dispositivo Android
ou
- Abra um emulador

Clique em:

```bash
Run ▶
```

---

# 📱 Telas do Sistema

## 🏠 MainActivity
Tela inicial com navegação principal.

---

## 📅 EventoActivity
Exibição dos eventos cadastrados em formato de cards.

---

## 📝 InscricaoActivity
Tela responsável pelas inscrições dos usuários.

---

## 🛠️ AdminActivity
Painel administrativo para gerenciamento do evento.

---

## ❓ FAQActivity
Perguntas frequentes sobre o evento.

---

## 📍 LocalizacaoActivity
Integração com Google Maps.

---

# 🎨 Padrão Visual

O projeto segue:

- Material Design
- Tema Dark
- Cores:
  - Azul `#2563EB`
  - Fundo `#0F172A`
  - Cards `#1E293B`

---

# 🔥 Melhorias Futuras

- Login de usuários
- API REST
- Firebase Authentication
- Confirmação por QRCode
- Certificados automáticos
- Integração online
- Painel Web administrativo

---

# 👨‍💻 Desenvolvedo

---

# 📄 Licença

Projeto acadêmico desenvolvido para fins educacionais.
