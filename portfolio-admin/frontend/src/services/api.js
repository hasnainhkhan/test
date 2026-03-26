import axios from 'axios';

const client = axios.create({
  baseURL: 'http://localhost:8080/api'
});

export async function getContent() {
  const { data } = await client.get('/content');
  return data;
}

export async function updateContent(payload) {
  const { data } = await client.put('/content', payload);
  return data;
}

export async function updateTheme(payload) {
  const { data } = await client.put('/content/theme', payload);
  return data;
}
