import { useState } from 'react';

export default function EditableField({ label, value, onSave, multiline = false, isHeading = false }) {
  const [editing, setEditing] = useState(false);
  const [draft, setDraft] = useState(value);

  const save = async () => {
    await onSave(draft);
    setEditing(false);
  };

  return (
    <div className="editable-field">
      <button className="edit-btn" onClick={() => setEditing((s) => !s)}>
        {editing ? 'Cancel' : `Edit ${label}`}
      </button>

      {editing ? (
        <div className="editor">
          {multiline ? (
            <textarea value={draft} onChange={(e) => setDraft(e.target.value)} rows={4} />
          ) : (
            <input value={draft} onChange={(e) => setDraft(e.target.value)} />
          )}
          <button className="save-btn" onClick={save}>
            Save
          </button>
        </div>
      ) : isHeading ? (
        <h1>{value}</h1>
      ) : (
        <p>{value}</p>
      )}
    </div>
  );
}
