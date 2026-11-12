# ---- Estágio 1: compilação ----
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY *.java ./
RUN javac -encoding UTF-8 -d out *.java

# ---- Estágio 2: execução (imagem final enxuta, só com JRE) ----
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Roda a aplicação com um usuário sem privilégios de root
RUN addgroup -S app && adduser -S app -G app
COPY --from=build /app/out ./
USER app

ENTRYPOINT ["java", "-cp", "/app", "Main"]
