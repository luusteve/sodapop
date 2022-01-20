FROM node:16

WORKDIR /usr/src/app/sodapop-frontend

COPY package*.json ./

RUN npm install
RUN npm install --global vue-cli
RUN npm install --save axios
RUN npm install --save jquery
# RUN npm install --save-dev webpack-dev-server 

EXPOSE 8087

CMD ["npm", "run", "dev"]