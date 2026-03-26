import { useEffect, useState } from 'react';
import { getContent, updateContent, updateTheme } from './services/api';
import EditableField from './components/EditableField';

const defaultData = {
  navTitle: 'My Portfolio',
  heroTitle: 'Hi, I am Hasnain',
  heroDescription: 'I build clean and modern web experiences.',
  themePrimaryColor: '#6c63ff'
};

export default function App() {
  const [content, setContent] = useState(defaultData);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function load() {
      try {
        const data = await getContent();
        setContent({ ...defaultData, ...data });
      } finally {
        setLoading(false);
      }
    }
    load();
  }, []);

  const saveField = async (field, value) => {
    const updated = { ...content, [field]: value };
    setContent(updated);
    await updateContent(updated);
  };

  const saveTheme = async (value) => {
    const updated = { ...content, themePrimaryColor: value };
    setContent(updated);
    await updateTheme({ themePrimaryColor: value });
  };

  if (loading) return <div className="loading">Loading admin preview...</div>;

  return (
    <div className="app" style={{ '--primary': content.themePrimaryColor }}>
      <nav className="navbar">
        <EditableField label="Nav Title" value={content.navTitle} onSave={(v) => saveField('navTitle', v)} />
      </nav>

      <section className="hero">
        <EditableField label="Hero Title" value={content.heroTitle} onSave={(v) => saveField('heroTitle', v)} isHeading />
        <EditableField
          label="Hero Description"
          value={content.heroDescription}
          onSave={(v) => saveField('heroDescription', v)}
          multiline
        />

        <div className="theme-editor">
          <label>Theme Color</label>
          <input type="color" value={content.themePrimaryColor} onChange={(e) => saveTheme(e.target.value)} />
        </div>
      </section>
    </div>
  );
}
